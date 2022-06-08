// 1 ms | O(N) | Greedy | Java
class Solution {
  public int jump(int[] nums) {
      int n = nums.length, maxReachable = 0, lastJumpedPos = 0, jumps = 0;
      for(int i = 0; i < n-1; i++) {
          maxReachable = Math.max(maxReachable, i + nums[i]);
          if(i == lastJumpedPos) {
              lastJumpedPos = maxReachable;
              jumps++;
          }
      }
      return jumps;
  }
}

// with annotation
public int jump(int[] nums) {
  int n = nums.length, maxReachable = 0, lastJumpedPos = 0, jumps = 0;
  for(int i = 0; i < n-1; i++) { // loop till last jump hasn't taken us till the end
      maxReachable = Math.max(maxReachable, i + nums[i]); // furthest index reachable on the next level from current level
      if(i == lastJumpedPos) { // current level has been iterated & maxReachable position on next level has been finalised
          lastJumpedPos = maxReachable; // so just move to that maxReachable position
          jumps++;  // and increment the level
      }
  // Key: jump  only gets updated after we iterate all possible jumps from previous level  This ensures jumps will only store minimum jump required to reach lastJumpedPos
  }
  return jumps;
}

// We can iterate over all indices maintaining the furthest reachable position from current index - maxReachable and currently furthest reached position - lastJumpedPos. Everytime we will try to update lastJumpedPos to furthest possible reachable index - maxReachable.

// Updating the lastJumpedPos separately from maxReachable allows us to maintain track of minimum jumps required. Each time lastJumpedPos is updated, jumps will also be updated and store the minimum jumps required to reach lastJumpedPos (On the contrary, updating jumps with maxReachable won't give the optimal (minimum possible) value of jumps required).

// We will just return it as soon as lastJumpedPos reaches(or exceeds) last index.

// We can try to understand the steps in code below as analogous to those in BFS as -

// maxReachable = max(maxReachable, i + nums[i]) : Updating the range of next level. Similar to queue.push(node) step of BFS but here we are only greedily storing the max reachable index on next level.

// i == lastJumpedPos : When it becomes true, current level iteration has been completed.

// lastJumpedPos = maxReachable : Set range till which we need to iterate the next level

// jumps++ : Move on to the next level.

// return jumps : The final answer will be number of levels in BFS traversal.

// For eg. Take the example : nums = [2,3,1,4,1,1,1,2]. This approach proceeds as illustrated in image below -