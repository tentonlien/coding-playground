package main

import (
	"fmt"
	"time"
)

func main()  {
	go hello()
	time.Sleep(50 * time.Millisecond)
}

func hello()  {
	fmt.Println("Hello GoRoutine")
}