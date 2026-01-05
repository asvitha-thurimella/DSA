class Solution {
    public long maxMatrixSum(int[][] matrix) {
    int row=matrix.length;
    int col=matrix[0].length;
    long sum=0;
    int count=0;
    int min=Integer.MAX_VALUE;
     for(int i=0;i<row;i++)
     {
        for(int j=0;j<col;j++)
        {
            if(matrix[i][j] < 0)
            {
             count++;
            }
             matrix[i][j]=Math.abs(matrix[i][j]);
             min=Math.min(min,matrix[i][j]);
             sum=sum+matrix[i][j];

        }
     }
      
     if (count % 2 != 0) {
            sum = sum - 2L * min;
            
            }
        
     
       return  sum ;
    }
}