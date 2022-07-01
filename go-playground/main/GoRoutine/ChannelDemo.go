package main

import (
	"fmt"
	"time"
)

func main() {
	c := make(chan int)
	go send(c)
	go receive(c)
	time.Sleep(3 * time.Second)
}

func send(c chan<- int) {
	for i := 0; i < 10; i ++ {
		c <- i
	}
}

func receive(c <-chan int) {
	for i := range c {
		fmt.Println("Received: ", i)
	}
}
