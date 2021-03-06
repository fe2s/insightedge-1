/*
 * Copyright (c) 2016, GigaSpaces Technologies, Inc. All Rights Reserved.
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

package org.apache.spark.sql.insightedge

import com.gigaspaces.metadata.StorageType
import org.insightedge.scala.annotation
import annotation._
import org.apache.spark.sql.types.StructType

import scala.beans.BeanProperty

/**
  * Stores the dataframe schema in space when dataframe is persisted.
  * Is required to be able to read the dataframe back into spark with it's schema.
  *
  * @param collection the name of the type of space documents in space
  * @param schema     the schema of dataframe being persisted
  */
class DataFrameSchema(
                       @BeanProperty
                       @SpaceId(autoGenerate = false)
                       var collection: String,

                       @BeanProperty
                       @SpaceStorageType(storageType = StorageType.BINARY)
                       var schema: StructType
                     ) {

  def this() = this(null, null)

}