package main

import (
	"bufio"
	"fmt"
	"io"
	"net"
)

func main() {
	var tcpAddr *net.TCPAddr
	tcpAddr, _ = net.ResolveTCPAddr("tcp", "127.0.0.1:8080")
	conn, err := net.DialTCP("tcp", nil, tcpAddr)
	if err != nil {
		fmt.Println("Client connect error: " + err.Error())
		return
	}
	defer conn.Close()
	fmt.Println(conn.LocalAddr().String() + ": Client connected!")
	onMessageReceived(conn)
}

func onMessageReceived(conn *net.TCPConn) {
	reader := bufio.NewReader(conn)
	b := []byte(conn.LocalAddr().String() + " say hello to server...\n")
	conn.Write(b)

	msg, err := reader.ReadString('\n')

	if err != nil {
		if err != io.EOF {
			fmt.Println("Read error:", err)
		}

	}
	fmt.Println("Server says:", msg)
}
