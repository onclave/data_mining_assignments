z_score_normalization <- function(v, v_mean, v_standard_deviation) {
  
  v_prime <- (v - v_mean) / (v_standard_deviation)
  
  return (v_prime)
}

zsn_matrix <- function(data_matrix) {
  
  apply(data_matrix, 1, function(row_matrix) {
    
    column_count <- 0
    
    for(value in row_matrix) {
      column_count <- column_count + 1
    }
    
    row_matrix <- array(c(row_matrix), dim = c(1, column_count, 1))
    row_mean <- apply(row_matrix, 1, mean)
    row_std <- apply(row_matrix, 1, sd)
    result <- 0
    
    for(value in row_matrix) {
      result <- z_score_normalization(value, row_mean, row_std)
      print(result)
    }
    
    print("pass")
  })
}