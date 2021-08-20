package com.firebasky.javassist;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.AdviceAdapter;

public class RemoteObjectInvocationHandlerHookVisitor extends ClassVisitor{
    public String className;
    public RemoteObjectInvocationHandlerHookVisitor(ClassVisitor cv, String className){
        super(Opcodes.ASM5, cv);
        this.className = className;
    }
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if ("invokeRemoteMethod".equals(name)) {
            mv = new RemoteObjectInvocationHandlerHookVisitorAdapter(mv, access, name, desc);
            System.out.println("Firebasky function invoke");
        }
        return mv;
    }

    public static class RemoteObjectInvocationHandlerHookVisitorAdapter extends AdviceAdapter {
        public RemoteObjectInvocationHandlerHookVisitorAdapter(MethodVisitor mv, int access, String name, String desc) {
            super(Opcodes.ASM5, mv, access, name, desc);
        }
        protected void onMethodEnter(){
            mv.visitVarInsn(ALOAD, 3);
            mv.visitInsn(ICONST_0);
            mv.visitLdcInsn("calc");
            //传递参数
            //利用的类，方法，参数类型和返回值
            mv.visitMethodInsn(INVOKESTATIC, "com/firebasky/utils/CC6", "getObject", "(Ljava/lang/String;)Ljava/lang/Object;", false);
            mv.visitInsn(AASTORE);
        }
    }
}

