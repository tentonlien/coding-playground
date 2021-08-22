package main

import "fmt"

func main() {
	fmt.Println("========== Array Demo ==========")

	// Define an one-dimension array
	// 定义一维数组
	a := [4] float64 { 3.14, 6.28 }
	b := [...] int { 3, 6, 9 }

	// Define an two-dimension array
	// 定义二维数组
	c := [3][4] int {
		{ 1, 2, 3, 4 },
		{ 5, 6, 7, 8 },
		{ 9, 10, 11, 12 }}
	fmt.Println("Two-Dimension Array:", c)

	// Get the length of array
	// 获取数组长度
	fmt.Printf("Length of a: %d, Length of b: %d\n", len(a), len(b))

	// 遍历数组方式1
	for i := 0; i < len(a); i ++ {
		fmt.Print(a[i], "\t")
	}
	fmt.Println()

	// 遍历数组方式2
	for _, value := range b {
		fmt.Print(value, "\t")
	}
	fmt.Println()
}
