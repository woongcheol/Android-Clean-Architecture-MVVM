`최근 업데이트 : '22. 08. 16.`
![image](https://user-images.githubusercontent.com/86638578/184826536-07acba13-afd9-47a0-9e93-d88be4868f80.png)

## 개요
#### ✔ 아키텍처 패턴(MVVM)을 통해 어플리케이션의 확장성과 재사용성을 높입니다.
#### ✔ 이외에도 Clean Architecture Repo에서 다양한 개념들을 확인하실 수 있습니다.
#### ✔ 오류 및 보완해야할 내용은 Contribution을 통해 기여부탁드리겠습니다🙇‍♂️  
</br>

## 목차
### MVVM 패턴
#### 1. Model
#### 2. View
#### 3. ViewModel

### Jetpack
#### 1. RecyclerView & ListAdapter & DiffUtil

### Q&A
#### AAC ViewModel과 MVVM ViewModel는 같은 것인가요?  
</br>

## MVVM 패턴
#### 패턴 특징
- View로부터 완전히 독립된 ViewModel을 사용하는 패턴입니다. 
- View와 ViewModel은 1:N의 관계를 갖을 수 있습니다.
- UI 변경에도 문제가 발생하지 않습니다.
#### Model 
- 데이터 저장, 수정, 삭제 관리를 합니다.
- 네트워크 통신을 합니다.
- Entity, Repository, DB, Util 클래스 등
#### View
- UI 조작을 담당합니다.
- Activity, Fragment, View, ViewDataBinding 등
#### ViewModel
- View에 표현될 데이터를 Model로 부터 가져와 가공하고 관리합니다.
- AAC ViewModel 클래스, BaseObservable 등
- 인스턴스 생성 방법
```kotlin
  val dataViewModel = ViewModelProvider(LifecycleOwner, ViewModelProvider.Factory).get(DataViewModel::class.java)
```
  - LifecycleOwner : 생명 주기를 담당하는 주체입니다. 일반적으로 액티비티 또는 프래그먼트입니다.
  - ViewModelProvider.Factory : ViewModel 인스턴스를 생성합니다.
- 제약사항
  - ViewModel에서 Context를 참조해서는 안된다. 화면 회전 등 기존 액티비티가 제거되면 메모리 누수가 발생한다.  
</br>

## Jetpack
#### RecyclerView & ListAdapter & DiffUtil
- 추가 예정  
</br>

## Q&A
#### AAC ViewModel과 MVVM ViewModel은 같은 것인가요?
- 다르다. AAC ViewModel은 Configuration Change가 발생해도 뷰 모델의 상태를 유지해줍니다.
- 또한, 범위 내에서 데이터의 공유가 쉬우며, LifeCycleOwner의 생명주기를 알고 있습니다.
