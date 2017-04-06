test_methhod <- function(some_matrix) {
  apply(some_matrix, 1, function(row_matrix) {
    print("pass")
    print(row_matrix)
  })
}