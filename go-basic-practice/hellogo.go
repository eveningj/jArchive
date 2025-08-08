package main

import "fmt"

func main() {
	fmt.Println("hello~~ go! HAPPY TO SEE")
	fmt.Println("안녕하세요 GO !")
	name := "5000"
	fmt.Println(name)

	message := "안녕하세요"
	fmt.Println(message)

	message = "메세지 변경입니다"
	fmt.Println(message)

	message = "hello! 또 변경, append 도 함"
	fmt.Println(message)

	var count int = 10
	count = count + count
	fmt.Println(count)

	var ptr *int = &count
	fmt.Println(*ptr)

}

// variable
var name string
var age int
var isActive bool

// declaration
var name2 string = "TINY LITTLE CUTE GO"
var age2 int = 5000
var isActive2 bool = true
var p float64 = 198.12312

var name3 = "NEW SEXY GO"
var age3 = 9999
var isActive3 = true
var p2 = 198.12121212

// multiple declaration
var x, y, z int

var (
	name5    string  = "go"
	version  float64 = 1.21
	isStable bool    = true
)

var vname, vage, vcity = "김철수", 30, "서울"
