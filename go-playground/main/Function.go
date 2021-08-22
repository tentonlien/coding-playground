package main

import "fmt"

func main() {
	fmt.Println("f1:", f1(3, 4))
	f2("f2:", 1, 2, 3)
	sum, sub := f3(1, 2)
	fmt.Println("f3:", sum, sub)
	deferDemo()
}

func f1(x, y int) int {
	return x + y
}

// 可变参数
func f2(title string, y ...int) int {
	fmt.Println(title, y)
	return 0
}

// 命名返回值
func f3(x, y int) (sum, sub int) {
	sum = x + y
	sub = x - y
	return
}

// defer 延迟执行
func deferDemo() {
	fmt.Println("Start")
	defer fmt.Println("Hey Hey Hey")
	defer fmt.Println("Ha Ha Ha")
	fmt.Println("End")
}