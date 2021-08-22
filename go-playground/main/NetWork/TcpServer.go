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
	tcpAddr, _ = net.ResolveTCPAddr("tcp", "127.0.0.1:8080")
	tcpListener, _ := net.ListenTCP("tcp", tcpAddr)
	defer tcpListener.Close()
	fmt.Printf("TCP server listening on port 8080...")
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
	i := 0
	for {
		message, err := reader.ReadString('\n')
		if err != nil || err == io.EOF {
			break
		}
		fmt.Println(string(message))
		time.Sleep(time.Millisecond * 2)
		msg := time.Now().String() + conn.RemoteAddr().String() + "Server say hello!\n"
		b := []byte(msg)
		conn.Write(b)
		i ++
		if i > 10 {
			break
		}
	}
}