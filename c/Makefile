CFLAGS = --std=c99 -fPIC

all: libSCARLib.so libSCARLib.jnilib
libSCARLib.so: SCARLibX11.o dsimple.o clientwin.o
	cc -lX11 -shared -Wl,-soname,libSCARLib.so -o libSCARLib.so SCARLibX11.o dsimple.o clientwin.o
SCARLibX11.o: SCARLibX11.c edu_js_SCARlib_SCARLib.h 
	cc -I"/usr/lib/jvm/java-6-openjdk/include" -I"/usr/lib/jvm/java-6-openjdk/include/linux" -fPIC -c SCARLibX11.c -o SCARLibX11.o

libSCARLib.jnilib: SCARLibOSX.o
	cc -dynamiclib -o libSCARLib.jnilib SCARLibOSX.o -framework JavaVM -framework Carbon
SCARLibOSX.o: SCARLibOSX.c
	cc --std=c99 -c -I/System/Library/Frameworks/JavaVM.framework/Headers -framework Carbon  SCARLibOSX.c -o SCARLibOSX.o
edu_js_SCARlib_SCARLib.h: ../bin/edu/js/SCARlib/SCARLib.class
	javah -classpath ../bin -jni edu.js.SCARlib.SCARLib
clean:
	-rm edu_js_SCARlib_SCARLib.h
	-rm SCARLibX11.o
	-rm SCARLibOSX.o
	-rm dsimple.o
	-rm clientwin.o