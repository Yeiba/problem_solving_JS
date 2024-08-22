/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

const twoSum = (nums, target) => {
    let storage = {};
    for (let [index, num] of nums.entries()) {
        if (storage[num] !== undefined) return [storage[num], index];
        storage[target - num] = index;
    }
};
let nums = [2, 5, 11, 8, 4];
let target = 9
console.log(twoSum(nums, target));


