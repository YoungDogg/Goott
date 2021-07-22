#include <stdio.h>
#include <string.h>
//baekjoon
//1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
int main() {
    
    char s[100];
    int s2[26];
    scanf("%s", s);
    
    for(int i = 0; i < 26; i++){
        int temp = s[i] - 97; //자리수
        
        s2[i] = -1;
        printf("%d ", s2[i]);
    }
    printf("\n");
    
    // s[100] 에서 -65한 인덱스를 s2에 집어넣는다
    return 0;
}

