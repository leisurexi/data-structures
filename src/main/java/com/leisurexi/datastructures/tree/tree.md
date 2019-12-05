# 定义
树（tree）是n（n>=0）个节点的有限集。当n=0时，称为空树。在任意一个非空树中，
有如下特点。
1. 有且仅有一个特定的称为根的节点。
2. 当n>1时，其余节点可分为m（m>0）个互不相交的有限集，每一个集合本身又是一个
树，并称为根的子树。

![WechatIMG1.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l0a5u4utj31hc0p9nha.jpg)

# 二叉树
二叉树（binary tree）是树的一种特殊形式。二叉，顾名思义，这种树的每个节点
**最多有2个孩子节点**。注意，这里是最多有两个，也可能只有1个，或者没有孩子
节点。

![WechatIMG3.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l0bqqyt8j31hc0p9000.jpg)

二叉树节点的两个孩子节点，一个被称为**左孩子（left child）**，一个被称为
**右孩子（right child）**。这两个孩子节点的顺序是固定的，就像人的左手就是
左手，右手就是右手，不能够颠倒或混淆。

此外，二叉树还有两种特殊形式，一个叫做**满二叉树**，另一个叫作**完全二叉树**。

**满二叉树:** 一个二叉树的所有非叶子节点都存在左右孩子，并且所有叶子节点都在
同一层级上，那么这个树就是满二叉树。简单点说，满二叉树的每一个分支都是满的。

![WechatIMG2.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l08oyogej31hc0p9kcw.jpg)

**完全二叉树:** 对一个有n个节点的二叉树，按层级顺序编号，则所有节点的编号为
从1到n。如果这个树所有节点和同样深度的满二叉树的编号为从1到n的节点位置相同，
则这个二叉树为完全二叉树。

![WechatIMG4.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l0cqwto4j31hc0p9tul.jpg)

在上图中，二叉树编号从1到12的12个节点，和前面满二叉树编号从1到12的节点位置
完全对应。因此这个树是完全二叉树。

完全二叉树的条件没有满二叉树那么苛刻: 满二叉树要求所有分支丢失满的；而完全
二叉树只需保证最后一个节点之前的节点都齐全即可。

# 二叉树可以使用的物理存储结构
1. 链式存储结构。

![WechatIMG5.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l149xdgaj31hc0p97os.jpg)

链式存储是二叉树最直观的存储方式。链表是一对一的存储方式，每一个链表节点拥有
data变量和一个指向下一节点的next指针。而二叉树稍微复杂一点，一个节点最多
可以指向左右两个孩子节点，所以二叉树的每一个节点包含三部分。
* 存储数据的data变量。
* 指向左孩子的left指针。
* 指向右孩子的right指针。

2. 数组存储结构。

![WechatIMG6.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l18lzzldj31hc0p9wz2.jpg)

使用数组存储时，会按照层级顺序把二叉树的节点放到数组中对应的位置上。如果某一个
节点的左孩子或右孩子空缺，则数组的相应位置也空出来。为什么这样设计呢？因为这样
可以更方便地在数组中定位二叉树的孩子节点和父节点。

假设一个父节点的下标是parent，那么它的左孩子节点下标就是`2 * parent + 1`，
右孩子节点下标就是`2 * parent + 2`。反过来，假设一个左孩子节点的下标是leftChild，
那么它的父节点下标就是`(left - child) / 2`。

假设节点4在数组中的下标是3，节点4是节点2的左孩子，节点2的下标可以直接通过计算
得出，
`节点2的下标 = (3 - 1) / 2 = 1`
显然，对于一个稀疏的二叉树来说，用数组表示法是非常浪费空间的。

# 二叉树的应用
二叉树包含许多特殊的形式，每一种形式都有自己的作用，但是其最主要的应用还在于
进行**查找操作和维持相对顺序**这两个方面。
1. 查找
二叉树的树形结构使它很适合扮演索引的角色。
**二叉查找树（binary search tree）** 主要在二叉树的基础上增加了一下几个条件。
* 如果左子树不为空，则左子树上所有节点的值均小于根节点的值
* 如果右子树不为空，则右子树上所有节点的值均大于根节点的值
* 左、右子树也都是二叉查找树

下图就是一个标准的二叉查找树。

![WechatIMG7.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l1n5kmtpj31hc0p9ts9.jpg)

二叉查找树的这些条件都是为了查找方便。

例如查找值为4的节点，步骤如下。
(1). 访问根节点6，发现4<6。

![WechatIMG8.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l1pfqm15j31hc0p9h5x.jpg)

(2). 访问节点6的左孩子左节点3，发现4>3。

![WechatIMG9.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l1rnw2w6j31hc0p9tti.jpg)

(3). 访问节点3的右孩子节点4，发现4=4，这正是要查找的节点。

![WechatIMG10.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l1skhidij31hc0p9wzy.jpg)

对于一个**节点分布相对均衡**的二叉查找树来说，如果节点总是是n，那么搜索节点的时间
复杂度就是**O(logn)**，和数的深度是一样的。这种依靠比较大小来逐步查找的方式，
和二分查找算法非常相似。

2. 维持相对顺序
这一点仍然要从二叉查找树说起。二叉查找树要求左子树小于父节点，右子树大于父节点，
正是这样保证了二叉树的有序性。因此二叉查找树还有另一个名字: **二叉排序树**（
binary sort tree）。新插入的节点，同样要遵循二叉排序树的原则。例如插入新
元素5，由于5<6，5>3，5>4，所以5最终会插入到节点4的右孩子位置。

![WechatIMG11.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l203x1yzj31hc0p9ttb.jpg)

再如插入新元素10，由于10>6，10>8，10>9，所以10最终会插入到节点9的右孩子
位置。

![WechatIMG12.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l21wlylfj31hc0p9wya.jpg)

这一切看起来很顺利，然而却隐藏着一个致命的问题。什么问题呢？下面请试着在二叉
查找树中依次插入9、8、7、6、5、4，看看会出现什么结果。

![WechatIMG13.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2581bgej31hc0p9qm3.jpg)

好好的一个二叉树，变成"坡脚"啦！不只是外观看起来变得怪异了，查询节点的时间
复杂度也退化成了O(n)。

怎么解决这个问题呢？这就涉及二叉树的 **自平衡** 了。二叉树自平衡的方式有多种，
如红黑树、AVL数、数堆等。

# 二叉树排序
从节点之间位置关系的角度来看，二叉树的遍历分为4种。
1. 前序遍历。
2. 中序遍历。
3. 后序遍历。
4. 层序遍历。
从更宏观的角度来看，二叉树的遍历归结为两个类。
1. 深度优先遍历（前序遍历、中序遍历、后序遍历）。
2. 广度优先遍历（层序遍历）。

## 深度优先遍历
深度优先和广度有限这两个概念不止局限于二叉树，它们更是一种抽象的算法思想，决定
了访问某些复杂数据结构的顺序。在访问树、图，或其他一些复杂数据结构时，这两个
概念常常被使用到。

所谓深度优先，顾名思义，就是偏向纵深，"一头扎到底"的访问方式。可能这中说法有
些抽象，下面就通过二叉树的 **前序遍历、中序遍历、后序遍历，** 来看一看深度
优先是怎么回事吧。
1. 前序遍历
二叉树的前序遍历，输出顺序是根节点、左子树、右子树。

![WechatIMG14.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2hz4c1rj31hc0p9x0b.jpg)

上图就是一个二叉树的前序遍历，每个节点左侧的序号代表该节点的输出顺序，详细步骤
如下。
(1). 首先输出的是根节点1。

![WechatIMG15.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2jde91jj31hc0p97q0.jpg)

(2). 由于根节点1存在左孩子，输出左孩子节点2.

![WechatIMG16.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2l4jwnij31hc0p9qnl.jpg)

(3). 由于节点2也存在左孩子，输出最孩子节点4。

![WechatIMG17.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2m05k0yj31hc0p9e0b.jpg)

(4). 节点4既没有左孩子，也没有右孩子，那么会到节点2，输出节点2的右孩子节点5。

![WechatIMG18.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2njk6kgj31hc0p9h7a.jpg)

(5). 节点5既没有左孩子，也没有右孩子，那么会到节点1，输出节点1的右孩子节点3。

![WechatIMG19.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2op58p5j31hc0p9nhz.jpg)

(6). 节点3没有左孩子，但是有右孩子，因此输出节点3的右孩子节点6。

![WechatIMG20.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2pwa002j31hc0p91e0.jpg)

到此为止，所有的节点都遍历输出完毕。

2. 中序遍历
二叉树的中序遍历，输出顺序是左子树、根节点、右子树。

![WechatIMG21.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2u1dt7ej31hc0p9qok.jpg)

上图就是一个二叉树的中序遍历，每个节点左侧的序号代表该节点的输出顺序，详细步骤如下。
(1). 首先访问根节点的左孩子，如果这个左孩子还拥有左孩子，则继续深入访问下去，一直
找到不再有左孩子的节点，并输出该节点。显然，第一个没有左孩子的节点是节点4。

![WechatIMG22.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2wa4doqj31hc0p94jo.jpg)

(2). 依照中序遍历的次序，接下来输出节点4的父节点2。

![WechatIMG23.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2y6bx37j31hc0p9kb9.jpg)

(3). 在输出节点2的右孩子节点5。

![WechatIMG24.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l2z4m7hmj31hc0p9h5r.jpg)

(4). 以节点2位根的左节点树已经输出完毕，这时再输出整个二叉树的根节点1。

![WechatIMG25.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l30gwb06j31hc0p97pm.jpg)

(5). 由于节点3没有左孩子，所以直接输出根节点1的右孩子节点3。

![WechatIMG26.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l31aobcbj31hc0p9e0i.jpg)

(6). 最后输出节点3的右孩子节点6。

![WechatIMG27.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l31zi6fnj31hc0p9wzg.jpg)

到此为止，所有的节点都遍历输出完毕。

3. 后序遍历
二叉树的后序遍历，输出顺序是左子树、右子树、根节点。

![WechatIMG28.jpeg](http://ww1.sinaimg.cn/large/006Vpl27gy1g9l33lqakzj31hc0p9x0f.jpg)

上图就是一个二叉树的后序遍历，每个节点左侧的序号代表该节点的输出顺序。