.data
z: .word 137
x: .word 0
y: .word 0

.text
.globl main

simpleFn:
   lw $t1, z
   lw $t2, x
   lw $t3, y
   li $t4, 4
   sw $t4, x
   li $t5, 3
   sw $t5, y
   lw $t2, x
   lw $t3, y
   mul $t6, $t2, $t3
   mul $t7, $t6, $t1
   sw $t7, x
   
   lw $a0, x
   li $v0, 1
   syscall
   jr $ra
main:
   jal simpleFn
   li $v0, 10
   syscall 
