var findShortestSubArray = function(nums) {
    const count = new Map(), left = new Map(), right = new Map();

    for (let i = 0; i < nums.length; i++) {
        const num = nums[i];
        if (!left.has(num)) left.set(num, i);
        right.set(num, i);
        count.set(num, (count.get(num) || 0) + 1);
    }

    let degree = Math.max(...count.values());
    let minLen = nums.length;

    for (let [num, freq] of count.entries()) {
        if (freq === degree) {
            minLen = Math.min(minLen, right.get(num) - left.get(num) + 1);
        }
    }

    return minLen;
};
