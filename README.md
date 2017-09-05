# Katana

Binds views and resources easily. Really easily. **Everywhere**.

```kotlin
//views
val myBeutyView: BeautyView by view(R.id.buety_vieww)
val myImage: ImageView by view(R.id.my_image)
val labels: List<BeutyLabel> by views(R.id.top_label, R.id.bottom_label)
    
//drawable
val myBeutyViewBackground by drawable(R.drawable.beuty_background)
val myImage by bitmap(R.drawable.beuty_image)
    
//strings
val serverErrorMessage by string(R.string.message_server_error)
    
//dimens
val myBeutyViewHeight by dimen(R.dimen.beuty_view_height)
val myBeutyViewTestSize by dimen(R.dimen.beuty_view_text_size, DimensionType.SP)
    
//ints
val animationDuration by integer(R.integer.fade_in_animation_duration)
    
```

### How?
<s>That's pure magic.</s> No, it's **Kotlin** and it's **delegates**!

### Why?
- Clearer to understand - no split between variable declaration and assignment
- Immutability - once resource assigned it will be same all time
- Laziness - resource initialized when it accessed first time
- No boilerplate code - forgot about `findViewById as Something` and `ContextCompat.getDrawable`
- No autogeneration of code - no annotation processing, no a lot generated classes

### What?

Library supports:
- `Views`
- `Strings`
- `Colors`
- `Dimens`
- `Integers`
- `Drawables`/`Bitmap`
- `Animations`

into:
- `Actvitiy`
- `Fragment` (default and support)
- `Dialog`
- `View`
- `Paste your classname here`

As said, it works everywhere. If it isn't standard Android component just implement `ViewFinderProvider` for view binding or/and `ContextProvider` for resource binding.

_- Oh noo, I must do something!_

Hey, take a look:

```kotlin
class MyClass(val external: View) : ViewFinderProvider {
    override fun provideViewFinder() = external::findViewById
}

class MySecondClass(val context: Context) : ContexrProvider {
    override fun provideContext() = context
}
```

That's all. Not so much, yep?
