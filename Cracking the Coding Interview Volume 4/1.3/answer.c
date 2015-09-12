#include <stdio.h>
#include <string.h>
 
int main (int argc, char *argv[]) {
	char* str = argv[1];

	if (str == NULL) return 0;
	int len = strlen(str);
	if (len < 2) return 0;
	
	int tail = 1;

	for (int i = 1; i < len; ++i) {

		int j;
		for (j = 0; j < tail; ++j) {
			if (str[i] == str[j]) break;
		}

		if (j == tail) {
			str[tail] = str[i];
			++tail;
		}
	}
	str[tail] = 0;

	printf("%s\n", str);
	return 0;
}