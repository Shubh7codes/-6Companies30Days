class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int temp[] = new int[n];
        int repeating = -1, missing = -1;
        
        for(int i=0; i<n; i++){
            temp[arr[i]-1]++;
            if(temp[arr[i]-1] > 1){
                repeating = arr[i];
            }
        }
        for(int i=0; i<n; i++){
            if(temp[i] == 0){
                missing = i + 1;
                break;
            }
        }
        
        return new int[]{repeating, missing};
    }
}
