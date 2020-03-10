# 定义

二叉堆本质上是一种**完全二叉树**，它分为两个类型**最大堆**和**最小堆**。

什么是最大堆呢？最大堆的任何一个父节点的值，都大于或等于它左、右孩子节点的值。

![WechatIMG29.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9oet8bf3mj31hc0p9tu8.jpg)

什么是最小堆呢？最小堆的任何一个父节点的值，都小于或等于它左、右孩子节点的值。

![WechatIMG30.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9oeungrojj31hc0p94ij.jpg)

二叉堆的根节点叫作**堆顶**。

最大堆和最小堆的特点决定了: 最大堆的对顶是整个堆中的**最大元素**；最小堆的对顶是整个堆中的**最小元素**。

# 二叉堆的自我调整

对于二叉堆，有如下几种操作。

1. 插入节点。

2. 删除节点。
3. 构建二叉堆。

这几种操作都给予堆的自我调整。所谓堆的自我调整，就是把一个不符合堆性质的**完全二叉树**，调整成一个堆。下面让我们以最小堆为例，看一看二叉堆是如何进行自我调整的。

#### 1.插入节点

当二叉堆插入节点时，插入位置是完全二叉树的最后一个位置。例如插入一个新节点，值时0。

![WechatIMG31.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9ofl8fdatj31hc0p9wzn.jpg)

这时，新节点的父节点5比0大，显然不符合最小堆的性质。于是让新节点”上浮“，和父节点交换位置。

![WechatIMG32.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9ofmudg4jj31hc0p97ou.jpg)

继续用节点0和3做比较，因为0小于3，则让新节点继续”上浮“。

![WechatIMG33.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9ofo0omy8j31hc0p9kcl.jpg)

继续比较，最终新节点0”上浮“到了堆顶位置。

![WechatIMG34.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9ofp5kjw8j31hc0p9ttk.jpg)

#### 2.删除节点

二叉堆删除节点的过程和插入节点的过程正好相反，所删除的是处于对顶的节点。例如删除最小堆的堆顶节点1。

![WechatIMG35.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9ofs882p0j31hc0p9tsn.jpg)

这时，为了继续维持完全二叉树的结构，我们把堆的最后一个节点10临时补到原本对顶的位置。

![WechatIMG36.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9oftl1pz0j31hc0p97nt.jpg)

接下来，让暂处堆顶位置的节点10和它的左、右孩子进行比较，如果左、右孩子节点中最小的一个（显然是节点2）比节点10小，那么让节点10”下沉“。

![WechatIMG37.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9ofv6g31dj31hc0p9qn6.jpg)

继续让节点10和它的左、右孩子做比较，左、右孩子中最小的是节点7，由于10大于7，让节点10继续”下沉“。

![WechatIMG38.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9ofwms50zj31hc0p9wzs.jpg)

这样一来，二叉堆重新得到了调整。

#### 3.构建二叉堆

构建二叉堆，也就是把一个无序的完全二叉树调整为二叉堆，本质就是让**所有非叶子节点一次”下沉“**。

下面举一个无序完全二叉树的例子，如下图所示。

![WechatIMG39.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9og09ax1bj31hc0p94j5.jpg)

首先，从最后一个非叶子节点开始，也就是从节点10开始。如果节点10大于它左、右孩子节点中最小的一个，则节点10”下沉“。

![WechatIMG40.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9og1mgq5sj31hc0p94k6.jpg)

接下来轮到节点3，如果节点3大于它左、右节点中最小的一个，则节点3”下沉“。

![WechatIMG41.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9og2p9pjwj31hc0p9tt9.jpg)

然后轮到节点1，如果节点1大于它左、右孩子节点中最小的一个，则节点1”下沉“。事实上节点1小于它的左、右孩子，所以不用改变。

接下来轮到节点7，如果节点7大于它左、右孩子节点中最小的一个，则节点7”下沉“。

![WechatIMG42.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9og53sgb9j31hc0p9nhr.jpg)

节点7继续比较，继续”下沉“。

![WechatIMG43.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9og5znl5kj31hc0p9qnm.jpg)

经过上述几轮比较和”下沉“操作，最终每一节点都小于它的左、有孩子节点，一个无序的完全二叉树就被构建成了一个最小堆。

# 时间复杂度

堆的插入操作时单一节点的”上浮“，堆的删除操作时单一节点的”下沉“，这两个操作的平均交换次数都是堆高度的一般，所以时间复杂度是**O(logn)**。至于堆的构建，时间复杂度是**O(n)**。

# 二叉堆的代码实现

二叉堆虽然是一个完全二叉树，但它的存储方式并不是链式存储，而是顺序存储。换句话说，二叉堆的所有节点都存储在数组中。

![WechatIMG45.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9ogmsjww4j31hc0p97ot.jpg)

在数组中，在没有左、右指针的情况下，如何定位一个父节点的左孩子和右孩子呢？

像上图那样，可以依靠数组下标来计算。

假设父节点的下标是parent，那么它的左孩子下标就是**2 * parent + 1**；右孩子下标就是**2 * parent + 2**。

```java
@Slf4j
public class BinaryHead {

    /**
     * "上浮"调整
     *
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        //temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            //无须真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * "下沉"调整
     *
     * @param array       待调整的堆
     * @param parentIndex 要"下沉"的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果有右孩子，且右孩子小于左孩子的值，定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值，则直接跳出
            if (temp <= array[childIndex]) {
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
     * 构建堆
     *
     * @param array 待调整的堆
     */
    public static void buildHeap(int[] array) {
        //从最后一个非叶子节点开始，依次做"下沉"调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        log.info(Arrays.toString(array));

        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        buildHeap(array);
        log.info(Arrays.toString(array));
    }

}
```

