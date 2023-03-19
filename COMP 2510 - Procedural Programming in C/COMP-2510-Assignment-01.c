#include <stdio.h>
#define CHECK(P) printf("%s...%s\n", (P) ? "PASSED" : "FAILED", #P);


/* returns max value of array of n elements. if max occurs multiple times, returns _first_ index */

size_t arr_index_of_first_max(const int a[], size_t n){ /* precondition: n > 0 */
	int max = a[0];
	size_t i;
	size_t ind = 0;
	for(i = 0; i < n; i++){
		if(a[i] > max){
			max = a[i];	
			ind = i;		
		}
	}
	return ind;
}


/* returns max value of array of n elements. if max occurs multiple times, returns last index */

size_t arr_index_of_last_max(const int a[], size_t n){ /* precondition: n > 0 */
	int max = a[0];
	size_t i;
	size_t ind = 0;
	for(i = 0; i < n; i++){
		if(a[i] >= max){
			max = a[i];
			ind = i;		
		}
	}
	return ind;
}

/* returns the number of times the maximum value occurs in an array of n elements */

size_t arr_count_max(const int a[], size_t n){ /* precondition: n > 0 */
	int max = a[0];
	size_t i;
	size_t count = 0;
	for(i = 0; i < n; i++){
		if(a[i] > max){
			max = a[i];
			count = 1;
		} else if(a[i] == max){
			count++;
		}
		
	}
	return count;
}

/* returns 1 if all corresponding elements of two integer arrays are equal. otherwise returns 0 */

int arr_equal(const int a[], const int b[], size_t n){
	size_t i;
	for(i = 0; i < n; i++){
		if(a[i] != b[i]){
			return 0;
		}
	}
	return 1;
} 

int main(void){
	int a[10] = {32, 5, 8, 22, 16, 9, 8, 4, 55, 7};
	int b[10] = {32, 5, 8, 22, 16, 9, 8, 4, 55, 7};
	int c[10] = {32, 5, 55, 22, 16, 9, 8, 4, 25, 10};
	int d[10] = {32, 55, 8, 22, 16, 9, 8, 55, 4, 9};
	int e[10] = {55, 5, 55, 22, 16, 55, 55, 4, 10, 8};
	
	/* ---------------------------------- test arr_index_of_first_max() */

	printf("testing arr_index_of_first_max\n");
	
	CHECK(arr_index_of_first_max(a, 10) == 8)
	CHECK(arr_index_of_first_max(b, 10) == 8)
	CHECK(arr_index_of_first_max(c, 10) == 2)
	CHECK(arr_index_of_first_max(d, 10) == 1)
	CHECK(arr_index_of_first_max(e, 10) == 0)
	
	
	/* ---------------------------------- test arr_index_of_last_max() */

	printf("testing arr_index_of_last_max \n");
	
	
	CHECK(arr_index_of_last_max(a, 10) == 8)
	CHECK(arr_index_of_last_max(b, 10) == 8)
	CHECK(arr_index_of_last_max(c, 10) == 2)
	CHECK(arr_index_of_last_max(d, 10) == 7)
	CHECK(arr_index_of_last_max(e, 10) == 6)
	

	/* ---------------------------------- test arr_count_max() */
	
	printf("testing arr_count_max \n");
	
	CHECK(arr_count_max(a, 10) == 1)
	CHECK(arr_count_max(b, 10) == 1)
	CHECK(arr_count_max(c, 10) == 1)
	CHECK(arr_count_max(d, 10) == 2)
	CHECK(arr_count_max(e, 10) == 4)
	
	
	/* ---------------------------------- test arr_equal() */
	
	printf("testing arr_equal \n");

	CHECK(arr_equal(a, b, 10) == 1);
	CHECK(arr_equal(a, c, 10) == 0);
	CHECK(arr_equal(d, e, 10) == 0);
		
	return 0;
}