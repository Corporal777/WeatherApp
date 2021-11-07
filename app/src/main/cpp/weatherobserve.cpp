#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring JNICALL
Java_org_otunjargych_weatherobserve_util_KeyHelper_getLib(JNIEnv *env, jobject thiz) {
    std::string appKey = "http://gosh.pp.ru/";
    return env->NewStringUTF(appKey.c_str());
}