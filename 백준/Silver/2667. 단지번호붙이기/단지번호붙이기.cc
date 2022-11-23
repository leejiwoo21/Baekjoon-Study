#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>

int flag = 0;
int mx[4] = { 1,0,-1,0 };
int my[4] = { 0,-1,0,1 };
int map[26][26] = {};
int nums = 0;
int danges[626] = {};
int N;
int index = 0;
void search(int i, int j) {
	for (int k = 0; k < 4; k++) {
		int x = i + mx[k];
		int y = j + my[k];
		if (x >= 0 && x < N && y >= 0 && y < N) {
			if (map[x][y] == 1) {
				nums++;
				map[x][y] = 0;
				search(x, y);
				flag = 1;
			}
		}
	}
}

int main() {
	scanf("%d", &N);
	char str[25] = "a";
	for (int i = 0; i < N; i++) {
		scanf("%s", &str);
		for (int j = 0; j < N; j++) {
			map[i][j] = str[j] - '0';
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			flag = 0;
			if (map[i][j] == 1) {
				nums++;
				flag = 1;
				map[i][j] = 0;
				search(i, j);
			}
			if (flag == 1) {
				danges[index] = nums;
				index++;
				nums = 0;
			}
		}
	}
	int temp = 0;
	for (int i = 0; i < index-1; i++) {
		for (int j = i+1; j < index; j++) {
			if (danges[i] > danges[j]) {
				temp = danges[i];
				danges[i] = danges[j];
				danges[j] = temp;
			}
		}
	}

	printf("%d\n", index);
	for (int i = 0; i < index-1; i++) {
		printf("%d\n", danges[i]);
	}
	printf("%d", danges[index-1]);
	return 0;
}