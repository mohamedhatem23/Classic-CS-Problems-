# Trapping Rain Water

## Problem

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.


## Examples

### Example 1
<img width="412" height="161" alt="image" src="https://github.com/user-attachments/assets/471cdfc4-cc95-4ef0-b818-5243b76e183e" />

**Input:**

```text
height = [0,1,0,2,1,0,1,3,2,1,2,1]
```

**Output:**

```text
6
```

### Example 2

**Input:**

```text
height = [4,2,0,3,2,5]
```

**Output:**

```text
9
```

## Constraints

* `n == height.length`
* `1 <= n <= 2 * 10^4`
* `0 <= height[i] <= 10^5`

## Approach

This problem can be solved using a **Monotonic Stack**.

The stack keeps track of bars that can form the left boundary of trapped water. Whenever we find a bar higher than the bar at the top of the stack, we can calculate the amount of water trapped between the current bar and the new stack top.

## Complexity

* **Time:** `O(n)`
* **Space:** `O(n)`

## Implementation

The solution is implemented in **Java**.
