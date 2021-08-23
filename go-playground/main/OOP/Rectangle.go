package main

import "fmt"

type Rectangle struct {
	Length int
	Width int
}

func (r *Rectangle) Area() int {
	return r.Length * r.Width
}

func main()  {
	r := Rectangle{4, 2}
	fmt.Println(r.Area())
}