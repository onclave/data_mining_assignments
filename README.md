# Data Mining Assignments
<br/>
<ul>
	<li>Z-score Normalization:
		<ul>
			<li>load z_score_normalization.R file in console</li>
			<li>on cli, run 'vector_array <- c(1, 3, 45, 23, 4, 23, 2, 67, 8)`. This is where you put your matrix in row major order.</li>
			<li>on cli, run `data_matrix <- array(vector_array, dim = c(3, 3, 1))`</li>
			<li>run `zsn_matrix(data_matrix)`</li>
			<li>This file also has a function `z_score_normalization(v, v_min, v_standard_deviation)` which can be directly called to run on a single data value v.</li>
		</ul>
	</li>
	<li>Min-Max Normalization:
		<ul>
			<li>on cli, run `vector_data <- c(123, 34, 54, 78, 455, 12, 1)`</li>
			<li>on cli, run `data_array <- array(vector_data, dim = c(1, 7, 1))`</li>
			<li>run `mmn_array(data_array, 100, 500, 0, 1)` where the function is defined as `mmn_array(data_array, current_min, current_max, new_min, new_max)`</li>
		</ul>
	</li>
</ul>
