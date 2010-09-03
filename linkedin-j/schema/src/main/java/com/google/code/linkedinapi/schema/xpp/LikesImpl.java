/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */

package com.google.code.linkedinapi.schema.xpp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.code.linkedinapi.schema.Like;
import com.google.code.linkedinapi.schema.Likes;

public class LikesImpl
    implements Serializable, Likes
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Like> likeList;
    protected Long total;

    public List<Like> getLikeList() {
        if (likeList == null) {
            likeList = new ArrayList<Like>();
        }
        return this.likeList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

}
