
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Basic ARM calculating Support and Confidence
 */

/**
 *
 * @author Debabrata Acharya
 */
public class AssociationRuleMining {
    
    private static final String[][] transactions = new String[5][3];
    private static final String[] antecedent = {"-1", "-1"};
    private static final String[] consequent = {"-1", "-1"};
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        
        populateTransactions();
        resolveRule();
        viewTransactions();
        viewRule();
        calculateSupport();
        calculateConfidence();
    }
    
    private static float calculateSupportCount() {
        
        float supportCount = 0;
        
        for(String[] transaction : transactions) {
            if(isItemsetPresentInTransaction(antecedent, transaction) && isItemsetPresentInTransaction(consequent, transaction)) supportCount++;
        }
        
        return supportCount;
    }
    
    private static void calculateSupport() { P("Support: " + calculateSupportCount() / (float)5.0); }
    
    private static void calculateConfidence() {
        float antecedentCount = 0;
        for(String[] transaction : transactions) { if(isItemsetPresentInTransaction(antecedent, transaction)) antecedentCount++; }
        P("Confidence: " + calculateSupportCount()/antecedentCount);
    }
    
    private static boolean isItemsetPresentInTransaction(String[] itemSet, String[] transaction) {
        
        boolean flag = false;
        
        for(String i : itemSet) {
            if(!i.equals("-1")) {
                for(String item : transaction) { if(item.toLowerCase().equals(i.toLowerCase())) { flag = true; break; } else flag = false; }
                if(!flag) break;
            }
        }
        
        return flag;
    }
    
    private static boolean isInTransaction(String item) {
        for(String[] transaction : transactions) { for(String i : transaction) { if(i.toLowerCase().equals(item.toLowerCase())) return true; } }
        return false;
    }
    
    private static boolean isInAntecedent(String item) {
        for(String i : antecedent) { if(i.toLowerCase().equals(item.toLowerCase())) return true; }
        return false;
    }
    
    private static void resolveRule() throws IOException {
        
        int total = 0;
        
        P("Enter your rule. At most 2 items can be set either as antecedent or consequent. No more than 3 items can be inserted in antecedent and consequent together.");
        P("Enter Antecedent(s) (Press 0 [zero] when done):\n");
        
        for(int i = 0; i < 2; i++) {
            
            String holder = bufferedReader.readLine();
            
            if(holder.equals("0")) break;
            else if(isInTransaction(holder)) { antecedent[i] = holder; total++; }
            else if(isInAntecedent(holder)) { P("This item is already in the antecedent. Please insert another item."); i--; }
            else { P("This item does not exist in any of the transactions. Please insert any other item already in the transaction database."); i--; }
        }
        
        P("\nEnter Consequent(s) (Press 0 when done):");
        
        for(int i = 0; i < 2; i++) {
            
            String holder = bufferedReader.readLine();
            
            if(holder.equals("0")) break;
            else if(isInTransaction(holder)) { consequent[i] = holder; total++; if(total == 3) break; }
            else { P("This item does not exist in any of the transactions. Please insert any other item already in the transaction database."); i--; }
        }
        
        P("\n\n");
    }
    
    private static void populateTransactions() throws IOException {
        
        P("Please insert 5 transactions each with 3 items. Items are not case sensitive.");
        
        for(int i = 0; i < 5; i++) {
            P("Transction " + (i + 1) + ":");
            for(int j = 0; j < 3; j++) { P("\t| Item " + (j + 1) + ": ", false); transactions[i][j] = bufferedReader.readLine(); }
        } P("Done!\n\n");
    }
    
    private static void viewTransactions() {
        P("Transaction database:"); for(String[] s : transactions) { P("\n"); for(String str : s) { P(str + " | ", false); } } P("\n\n");
    }
    
    private static void viewRule() {
        
        P("Rule:");
        for(String ant : antecedent) { if(!ant.equals("-1")) P("(" + ant + ")", false); }
        for(String con : consequent) { if(!con.equals("-1")) P("(" + con + ")", false); }
        P("\n\n");
    }
    
    private static void P(String str) { P(str, true); }
    private static void P(String str, boolean newLine) { if(newLine) System.out.println(str); else System.out.print(str); }
}