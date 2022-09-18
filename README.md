`최근 업데이트 : '22. 09. 18.`  

![image](https://user-images.githubusercontent.com/86638578/184826536-07acba13-afd9-47a0-9e93-d88be4868f80.png)

## 개요
#### ✔ 아키텍처 패턴(MVVM)을 통해 어플리케이션의 확장성과 재사용성을 높입니다.
#### ✔ 이외에도 Clean Architecture Repo에서 다양한 개념들을 확인하실 수 있습니다.
#### ✔ 오류 및 보완해야할 내용은 Contribution을 통해 기여부탁드리겠습니다🙇‍♂️
</br>

## 목차
### 앱 아키텍처 가이드
### MVVM 패턴
#### 1. Model
#### 2. View
#### 3. ViewModel

### Jetpack
#### 1. RecyclerView & ListAdapter & DiffUtil

### Q&A
#### AAC ViewModel과 MVVM ViewModel는 같은 것인가요?
</br>

## 앱 아키텍쳐 가이드
#### 사용자 경험(Mobile app user experiences)
- 안드로이드 앱에는 4대 컴포넌트(Activity 등)를 비롯해 여러 앱 구성요소가 포함됩니다.
- 이러한 구성요소는 대부분 Manifest에 선언하며, Android OS에서 이 파일을 사용해 기기에 앱을 통합하는 방법을 결정합니다.
- 사용자가 짧은 시간 내 여러 앱과 상호작용하는 등 사용자 중심의 워크플로 및 작업에 맞게 조정될 수 있어야합니다.
- 더불어 기기의 리소스 제한으로, 새로운 앱을 위한 공간을 확보하도록 언제든지 일부 앱 프로세스를 종료할 수 있어야합니다.
#### 아키텍처 원칙(Common architectural principles)
- 안드로이드 앱이 커짐에 따라 테스트의 용이성, 앱의 견고함, 확장성을 위해 아키텍처를 정의하는 것이 중요합니다.
- 앱의 아키텍쳐는 앱의 각 부분과 각 부분이 필요한 기능 간의 경계를 정의합니다
#### 관심사 분리(Separation of concerns)
- 가장 중요한 원칙은 관심사에 대한 분리입니다.
- 액티비티 등에 모든 코드를 작성하는 실수는 매우 흔하게 일어납니다.
- UI 기반 클래스는 오직 UI 및 운영체제와의 상호작용에 대한 로직만 포함해야합니다.
- 이러한 클래스들은 최대한 가볍게 유지하여 컴포넌트들의 수명주기와 관련된 문제들을 피하고, 클래스들의 테스트 가능성을 높입니다.
- 명심해야할 것은 액티비티와 프래그먼트를 구현하는 것은 소유하는 것이 아니라 안드로이드 OS와 앱 사이를 이어주는 클래스라는 것입니다.
- OS는 사용자의 상호작용에 의하거나 메모리 부족 등의 시스템 조건으로 인해 언제든지 클래스를 제거할 수 있습니다.
- 사용자 경험을 높이고 앱을 잘 관리하기 위한 환경을 위해 클래스에 대한 의존성을 최소화해야합니다.
#### 데이터 모델에서 UI 도출(Drive UI from data models)
- 데이터 모델은 앱의 데이터로, 앱의 UI 요소와 기타 요소로부터 독립된 상태이다.
- 어떠한 구성요소의 수명주기와 관련되지 않았으나 OS가 프로세스를 삭제할 경우 데이터 모델도 삭제된다.
- 하지만 지속 모델은 앱이 제거되어도 사용자 데이터가 삭제되지 않으며, 오프라인 상태에서도 앱이 잘 작동되어집니다.
- 따라서 데이터 모델 클래스를 기반으로 앱 아키텍처를 구현한다면 테스트의 용이성과, 견고함이 더욱 높아집니다.
#### 단일 소스 저장소(Single source of truth)
- 앱에서 새로운 데이터 타입을 정의할 때, 단일 소스 저장소(SSOT)를 할당해야합니다.
- SSOT는 데이터의 소유자로, 오직 SSOT만 데이터를 수정 및 변경할 수 있습니다.
- 이를 위해 SSOT는 immutable 타입을 사용하여 이벤트 수신 및 함수를 통해 외부로부터 데이터를 노출하고 수정합니다.
- 이점은 다음과 같습니다.
- 특정 유형 데이터의 모든 변경사항을 한 곳에서 일원화, 데이터의 보호, 데이터의 변경 사항을 추적하기 쉬움
- 데이터 소스는 오프라인일 경우, 주로 DB일 경우가 많지만 ViewModel과 UI일 때도 있습니다.

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
#### DiffUtil
- RecyclerView 라이브러리에 있는 유틸리티 클래스입니다.
- 데이터가 부분적으로 변경돼도 전체를 다시 업데이트 해야하는 nofityDataSetChanged()의 불필요한 교체 비용을 줄입니다.
- 기존 데이터와 변경된 데이터의 차이를 구하는 DiffUtil.Callback()를 상속받아 구현합니다.
```kotlin
class BookListDiffCallback(
  private val oldList: ArrayList<BookContent>,
  private val newList: ArrayList<BookContent>
) : DiffUtil.Callback() {
  override fun getOldListSize(): Int = oldList.size

  override fun getNewListSize(): Int = newList.size

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
    oldList[oldItemPosition].volumeInfo == newList[newItemPosition].volumeInfo

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
    oldList[oldItemPosition] == newList[newItemPosition]
}
```
- Adapter 내에 메서드를 구현합니다. 메서드 내에서 `dispatchUpdatesTo(adapter)`를 통해 부분적으로 데이터를 교체하라는 notify가 실행됩니다.
```kotlin
fun replaceItems(newBookList: ArrayList<BookContent>) {
  val adapter = this
  val diffCallback = BookListDiffCallback(bookList, newBookList)
  val diffResult = DiffUtil.calculateDiff(diffCallback)

  bookList.clear()
  bookList.addAll(newBookList)

  diffResult.dispatchUpdatesTo(adapter)
}
```
- 데이터가 많을 경우를 대비해 비동기 처리할 수 있도록 해당 메서드를 비동기 처리하여 실행합니다.
```kotlin
model.loadBookContent("android", "books", page)
model.getAll().observe(viewLifecycleOwner, Observer { content ->
  lifecycleScope.launch() {
    bookAdapter.replaceItems(content)
  }
})
```

</br>

## Q&A
#### AAC ViewModel과 MVVM ViewModel은 같은 것인가요?
- 다르다. AAC ViewModel은 Configuration Change가 발생해도 뷰 모델의 상태를 유지해줍니다.
- 또한, 범위 내에서 데이터의 공유가 쉬우며, LifeCycleOwner의 생명주기를 알고 있습니다.
