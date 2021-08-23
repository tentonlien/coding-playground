package main

import (
	"bufio"
	"fmt"
	"io"
	"net"
	"time"
)

func main() {
	var tcpAddr *net.TCPAddr
	tcpAddr, _ = net.ResolveTCPAddr("tcp", "127.0.0.1:16379")
	tcpListener, _ := net.ListenTCP("tcp", tcpAddr)
	defer tcpListener.Close()
	fmt.Println("TCP server listening on port 8080...")
	for {
		tcpConn, err := tcpListener.AcceptTCP()
		if err != nil {
			fmt.Println("Accept error:", err)
			continue
		}
		fmt.Println("A client connected:", tcpConn.RemoteAddr().String())
		go tcpPipe(tcpConn)
	}

}


func tcpPipe(conn *net.TCPConn) {
	ipStr := conn.RemoteAddr().String()
	defer func() {
		fmt.Println("Disconnected:", ipStr)
		conn.Close()
	}()
	reader := bufio.NewReader(conn)

	for {
		message, err := reader.ReadString('\n')
		if err != nil || err == io.EOF {
			break
		}
		fmt.Println(message)
		time.Sleep(time.Millisecond * 2)
		fmt.Println("Write...")
		msg := time.Now().String() + conn.RemoteAddr().String() + " server say hello!\n"
		b := []byte(msg)
		conn.Write(b)
	}
}