package stack

// 239. 滑动窗口最大值
// https://leetcode.cn/problems/sliding-window-maximum/description/
// 窗口移动时，对单调递减队列进行入队与出队

fun main() {
    println(maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3).contentToString())
    println(maxSlidingWindow(intArrayOf(1), 1).contentToString())
    println(maxSlidingWindow(intArrayOf(9,10,9,-7,-4,-8,2,-6), 5).contentToString())
}

private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    class MyQueue {
        val queue = ArrayDeque<Int>()

        // 保持队列是单调递减的
        fun push(x: Int) {
            while (queue.isNotEmpty() && queue.last() < x) {
                queue.removeLast()
            }
            queue.addLast(x)
        }

        fun pop(value: Int) {
            if (queue.isNotEmpty() && queue.first() == value) {
                queue.removeFirst()
            }
        }

        fun first() = queue.first()
    }

    val queue = MyQueue()
    val result = IntArray(nums.size - k + 1)

    for (i in 0 until k) {
        queue.push(nums[i])
    }
    var index = 0
    result[index++] = queue.first()

    for (i in k until nums.size) {
        queue.pop(nums[i - k])
        queue.push(nums[i])
        result[index++] = queue.first()
    }

    return result
}