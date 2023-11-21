.data
x: .word 1
promt0: .asciiz "x = "
promt1: .asciiz "\n"

.text
.globl main

main:
   slt $t1, $t0, 10
   <- x<10, -, $t1
   if_false $t1, -, L1
   + x, 1, $t2
   
   li $v0, 4
   la $a0, promt0
   syscall
   move $a1, $t0
   
   li $v0, 1
   syscall
   
   li $v0, 4
   la $a2, promt1
   syscall
   li $v0, 10
   syscall 
