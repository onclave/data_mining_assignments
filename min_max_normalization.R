min_max_normalization <- function(value, min, max, new_min, new_max) {
  
  v_prime <- (((value - min) / (max - min)) * (new_max - new_min)) + new_min
  
  return (v_prime)
}

mmn_array <- function(data_array, min, max, new_min, new_max) {
  
  for(data in data_array) {
    print(min_max_normalization(data, min, max, new_min, new_max))
  }
}