======================
MediaStorePhotoAdapter
copyright(c) 2014 saki t_saki@serenegiant
Licensed under the Apache License, Version 2.0 (the "License");
======================
 
 MediaStorePhotoAdapter is a descendent of CursorAdapter that can load images asynchronusly
 from MediaStore.Images.Thumbnails and set them to ImageView(that id is R.id.thumbnail)
 there are two type mode, one is displaying all images (DISPLAY_IMAGE)
 and the other is group by bucketId and shows only top image of each group (DISPLAY_BUCKET).
 You can also narrow the range of displaying images with bucketid in DISPLAY_IMAGE mode.

 MediaStorePhotoAdapter also has several helper method to help you manipulating image on 
 MediaStore.Images.
 
 The most easy way to use MediaStorePhotoAdapter is, just create and set to GridView
 and ListView etc. with #setAdapter.
 Please see demo app.
 
======================
 Most code of LoaderDrawable in MediaStorePhotoAdapter is originally came
 from BitmapJobDrawable.java in Android Gallery app
 
 Copyright (C) 2013 The Android Open Source Project

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

======================

