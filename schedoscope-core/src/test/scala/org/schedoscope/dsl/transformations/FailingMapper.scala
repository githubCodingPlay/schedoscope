/**
  * Copyright 2015 Otto (GmbH & Co KG)
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
package org.schedoscope.dsl.transformations

import java.io.IOException

import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Mapper

class FailingMapper extends Mapper[Text, Text, Text, Text] {

  throw new IOException("failing like hell")

  @throws(classOf[IOException])
  @throws(classOf[InterruptedException])
  def map(key: Text, value: Text, context: Context) {
    //FIXME: why can't I overwrite map here??
    throw new IOException("failing like hell")
  }

}