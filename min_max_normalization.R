min_max_normalization <- function(value, min, max, new_min, new_max) {
  
  v_prime <- (((value - min) / (max - min)) * (new_max - new_min)) + new_min
  
  return (v_prime)
}