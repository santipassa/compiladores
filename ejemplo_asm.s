.section	.rodata
.LC0:
	.string	"%d"

.text
	.globl	main
	


.type	main, @function
main:
pushl	%ebp
movl	%esp, %ebp
subl	$16, %esp
//restar maximo offset al stack pointer
movl $1,%eax
subl -4(%ebp),%eax
movl %eax, -8(%ebp)
movl	$8, 4(%esp)
movl	$.LC0, (%esp)
call	printf
	
leave
ret

