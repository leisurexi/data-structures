package com.leisurexi.data.structures.stack;


/**
 * 用栈实现浏览器的前进和后退功能
 *
 * @author: leisurexi
 * @date: 2020-10-15 14:57
 */
public class BrowserStack {

    private DynamicArrayStack<String> x;
    private DynamicArrayStack<String> y;

    public BrowserStack() {
        this.x = new DynamicArrayStack<>();
        this.y = new DynamicArrayStack<>();
    }

    /**
     * 浏览新页面
     */
    public void newPage(String page) {
        x.push(page);
        y.clear();
        System.out.println("当前页面: " + page);
    }

    /**
     * 后退
     */
    public void backup() {
        String currPage = x.pop();
        if (currPage == null || x.peer() == null) {
            System.out.println("无法后退");
        } else {
            y.push(currPage);
            System.out.println("当前页面: " + x.peer());
        }
    }

    /**
     * 前进
     */
    public void advance() {
        String lastPage = y.pop();
        if (lastPage != null) {
            x.push(lastPage);
            System.out.println("当前页面: " + lastPage);
        } else {
            System.out.println("无法前进");
        }
    }

    public static void main(String[] args) {
        BrowserStack stack = new BrowserStack();
        stack.newPage("页面A");
        stack.newPage("页面B");
        stack.newPage("页面C");

        // B
        stack.backup();

        // C
        stack.advance();

        // B
        stack.backup();

        //D
        stack.newPage("页面D");

        // 无
        stack.advance();

        // B
        stack.backup();

        // A
        stack.backup();

        // 无
        stack.backup();

    }

}
