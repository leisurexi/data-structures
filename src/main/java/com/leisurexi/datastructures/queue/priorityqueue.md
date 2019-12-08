# 定义

优先队列不再遵循先入先出的原则，而是分为两种情况。

* 最大优先队列，无论入队顺序如何，都是当前最大的元素优先出队
* 最小优先队列，无论入队顺序如何，都是当前最小的元素优先出队

例如有一个最大优先队列，其中的最大元素时8，那么虽然8并不是队头元素，但出队时仍然让元素8首先出队。

![WechatIMG46.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9p4ram5cwj31hc0p9x2v.jpg)

要实现以上需求，利用线性数据结构并非不能实现，但是时间复杂度较高。

# 优先队列的实现

先来回顾一下二叉堆的特性。

1. 最大堆的堆顶是整个堆中的最大元素。
2. 最小堆的堆顶是整个堆中的最小元素。

因此，可以用最大堆来实现最大优先队列，这样的话，每一次入队操作就是堆的插入操作，每一次出队操作就是删除堆顶节点。

**入队操作**具体步骤如下。

1.插入新节点5。

![WechatIMG47.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9p4wtiiq1j31hc0p97q5.jpg)

2.新节点5”上浮“到合适位置。

![WechatIMG48.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9p4xbvi35j31hc0p9aud.jpg)

**出队操作**具体步骤如下。

1.让原堆顶节点10出队。

![WechatIMG49.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9p4y3v5q5j31hc0p9dzj.jpg)

2.把最后一个节点1替换到堆顶位置。

![WechatIMG50.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9p4ytvn08j31hc0p9ttj.jpg)

3.节点1”下沉“，节点9称为新堆顶。

![WechatIMG51.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9p4zhtq1fj31hc0p91d4.jpg)



二叉堆节点”上浮“和”下沉“的时间复杂度都是**O(logn)**，所以优先队列入队和出队的时间复杂度也是**O(logn)**！

# 代码实现

```java
/**
* 基于最大堆实现的最大有限队列
*/
@Slf4j
public class PriorityQueue {

    private int[] array;
    private int size;

    public PriorityQueue() {
        //队列初始长度为32
        this.array = new int[32];
    }

    /**
     * 入队
     *
     * @param key 入队元素
     */
    public void enQueue(int key) {
        //队列长度超出范围，扩容
        if (size >= array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * 出队
     *
     * @return
     */
    public int deQueue() {
        if (size <= 0) {
            throw new IllegalStateException("the queue is empty!");
        }
        //获取堆顶元素
        int head = array[0];
        //让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * "上浮"调整
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        //temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            //无须真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * "下沉"调整
     */
    private void downAdjust() {
        //temp保存父节点的值，用于最后的赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            //如果父节点大于任何一个孩子的值，直接跳出
            if (temp >= array[childIndex]) {
                break;
            }
            //无须真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 队列扩容
     */
    private void resize() {
        //队列容量翻倍
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(10);
        queue.enQueue(2);
        queue.enQueue(7);
        log.info("出队元素: {}", queue.deQueue());
        log.info("出队元素: {}", queue.deQueue());
    }

}
```



