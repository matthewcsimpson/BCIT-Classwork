#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define CHECK(P) printf("%s...%s\n", (P) ? "PASSED" : "FAILED", #P);


/* returns 1 if the string s contains a digit, otherwise returns 0 */
int str_has_digit(const char s[]){
	size_t i;
	for(i = 0; s[i] != '\0'; i++){
		if(isdigit(s[i])){				
			return 1;
		}
	}
	return 0;
}


/* replaces all occurrences of the character specified by oldc in the string s by the character specified by newc.  returns number of replacements */
size_t str_replace_all(char s[], int oldc, int newc){
 	size_t counter = 0;
	size_t i;
 	for(i = 0; s[i] != '\0'; i++){
 		if(s[i] == oldc){
 			s[i] = newc;
 			counter++;
 		}
 	}
 	return counter;
}

/* replace only the last occurence of the character specified by oldc in the string s by the character specified by newc. returns 1 if replacement has been made, otherwise returns 0 */

int str_replace_last(char s[], int oldc, int newc){
	int check = 0;
	size_t cindex;
	size_t i;
	for(i = 0; s[i] != '\0'; i++){
		if(s[i] == oldc){
			cindex = i;
			check = 1;
		}
	}
	if(check == 1){
		s[cindex] = newc;
	}

	return check;
}

/* returns 1 if the strings s and t are the same, i.e. they have the same sequence of characters, otherwise returns 0 */ 
int str_equal(const char s[], const char t[]){

	size_t i;
	size_t j; 
	for(i = 0; s[i] != '\0'; i++){
	}
	for(j = 0; t[j] != '\0'; j++){
		if(i >= j){
			return 0;
		}
		if(s[j] != t[j]){
			return 0;
		}
	}
	return 1; 
}

/* Main Function */ 

int main(void){

	char a[] = "geeks";
	char b[] = "g33ks";
	
	char c[] = "geeks";
	char d[] = "g33ks";
	
	char e[] = "geeks";
	
	char f[] = "geeks";
	char g[] = "geeks";
	char h[] = "greeks";
	
	char str1[] = "hell";
	char str2[] = "hello";
	
	CHECK(str_equal(str1, str2) == 0);

	CHECK(str_has_digit(a) == 0);
	CHECK(str_has_digit(b) == 1);
	
	CHECK(str_replace_all(c, 'g', 'l') == 1);
	CHECK(str_replace_all(d, '3', 'e') == 2);
	
	CHECK(strcmp(a, e) == 0);
	CHECK(strcmp(d, "geeks") == 0);
	
	CHECK(str_replace_last(e, 'e', 'f') == 1);
	CHECK(str_replace_last(e, 'g', 'w') == 1);
	
	CHECK(str_equal(f, g) == 1);
	CHECK(str_equal(g, h) == 0);
	
	return 0;
}