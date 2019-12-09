# MVVM模式封装
## DataBinding
DataBinding用于数据绑定-数据和视图绑定  
数据驱动，数据改变自动刷新视图

在build.gradle文件的android下面添加
```
dataBinding {
        enabled = true
    }
```

## LiveData
LiveData内部通过封装了Lifecycle组件来自动解除订阅而避免内存泄漏  

* setValue在主线程调用  
postValue在子线程调用

* LiveData内部维护了状态  
observer只能监听到onStart，onResume，onPuse  
observerForever方法可以监听到Activity生命周期所有回调

## ViewModel
更易于保存数据和组件间通信  
通过Fragment持有数据来实现，高版本更改了实现方式