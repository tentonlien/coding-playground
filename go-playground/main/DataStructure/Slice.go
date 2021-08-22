package main

import "fmt"

func main() {
	fmt.Println("========== Slice Demo ==========")

	//var a [] string
	var b [] int64 = make([]int64, 5)
	b = append(b, 32)
	//c := make([]int64, 5)
	fmt.Printf("Len of b: %d, Cap of b: %d\n", len(b), cap(b))
}

