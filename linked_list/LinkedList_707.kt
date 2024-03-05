package linked_list

import ListNode
import printList

// 707. 设计链表
// https://leetcode.cn/problems/design-linked-list/
// 定义虚拟头节点之后，添加或删除需要找到index前一个节点
//                  dummy -> node -> node -> node -> node
// dummy index       0     -> 1    -> 2    -> 3    -> 4
// real index                 0    -> 1    -> 2    -> 3

fun main() {
    val myLinkedList = MyLinkedList()
    myLinkedList.addAtHead(2)
    myLinkedList.println()
    myLinkedList.deleteAtIndex(1)
    myLinkedList.println()
    myLinkedList.addAtHead(2)
    myLinkedList.println()
    myLinkedList.addAtHead(7)
    myLinkedList.println()
    myLinkedList.addAtHead(3)
    myLinkedList.println()
    myLinkedList.addAtHead(2)
    myLinkedList.println()
    myLinkedList.addAtHead(5)
    myLinkedList.println()
    myLinkedList.addAtTail(5)
    myLinkedList.println()
    println(myLinkedList.get(5))
    myLinkedList.deleteAtIndex(6)
    myLinkedList.deleteAtIndex(4)
    myLinkedList.println()
}

// 定义尾节点，把自己带坑里去了！！
class MyLinkedListOld() {
    private var head: ListNode? = null
    private var tail: ListNode? = null
    private var size = 0

    fun get(index: Int): Int {
        if (index < 0 || index >= size) return -1
        var cur = head
        for(i in 0 until size) {
            if (i == index) {
                return cur!!.`val`
            }else {
                cur = cur?.next
            }
        }
        return -1
    }

    fun addAtHead(`val`: Int) {
        if (head == null) {
            head = ListNode(`val`)
            tail = head
        } else {
            val node = ListNode(`val`)
            node.next = head
            head = node
        }
        size++
    }

    fun addAtTail(`val`: Int) {
        if (head == null) {
            head = ListNode(`val`)
            tail = head
        }else {
            val node = ListNode(`val`)
            tail?.next = node
            tail = node
        }
        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index < 0) return
        if (index > size) return
        if (size == 0 || index == 0) {
            addAtHead(`val`)
        }else if (index == size){
            addAtTail(`val`)
        }else {
            val node = ListNode(`val`)
            var dummy = ListNode(`val`)
            dummy.next = head
            var cur: ListNode? = dummy
            for (i in 0 until size) {
                if (i == index) {
                    node.next = cur?.next
                    cur?.next = node
                    break
                }else {
                    cur = cur?.next
                }
            }
            dummy.next = null
            size++
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index == 0) {
            head = head?.next
            size--
        }else {
            var cur = head
            var curIndex = 1
            while (cur?.next != null) {
                if (curIndex == index) {
                    cur.next = cur.next?.next
                    if (size - 1 == index) {
                        tail = cur
                    }
                    size--
                    break
                }else {
                    cur = cur.next
                }
                curIndex++
            }
        }
    }

    fun println() {
        printList(head)
    }
}

class MyLinkedList() {
    private var dummy: ListNode = ListNode(-1)
    private var size = 0

    fun get(index: Int): Int {
        if (index >= size || index < 0) return -1
        var i = index
        var cur = dummy.next
        while (i-- > 0) {
            cur = cur?.next
        }
        return cur?.`val` ?: -1
    }

    fun addAtHead(`val`: Int) {
        val node = ListNode(`val`)
        node.next = dummy.next
        dummy.next = node
        size++
    }

    fun addAtTail(`val`: Int) {
        var cur: ListNode? = dummy
        while (cur?.next != null) {
            cur = cur.next
        }
        val node = ListNode(`val`)
        cur?.next = node
        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if(index > size) return
        var cur: ListNode? = dummy
        var i = if(index < 0) 0 else index
        while (i-- > 0) {
            cur = cur?.next
        }
        val node = ListNode(`val`)
        node.next = cur?.next
        cur?.next = node
        size++
    }

    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= size) return
        var cur: ListNode? = dummy
        var i = index
        while (i-- > 0) {
            cur = cur?.next
        }
        cur?.next = cur?.next?.next
        size--
    }


    fun println() {
        printList(dummy.next)
    }
}
