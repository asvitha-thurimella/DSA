class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res=new ArrayList<>();
    ArrayList sub=new ArrayList<>();
    backtracking(res,sub,candidates,target,0,0);
    return res;
    }
    public void backtracking(List<List<Integer>> res,List<Integer> sub,int[] candidates,int target,int i,int sum)
    {
    if(sum>target)
    {
        return;
    }

      if(sum==target) 
      {
         
         res.add(new ArrayList<>(sub));
         return;
      }    
      for(int j=i;j<candidates.length;j++)
      {
      sub.add(candidates[j]);
      backtracking(res, sub, candidates, target, j, sum + candidates[j]);
      sub.remove(sub.size()-1);
     
    }
}
}
   
    
