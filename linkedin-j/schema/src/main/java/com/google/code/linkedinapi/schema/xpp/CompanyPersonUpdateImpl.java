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

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.Action;
import com.google.code.linkedinapi.schema.CompanyPersonUpdate;
import com.google.code.linkedinapi.schema.NewPosition;
import com.google.code.linkedinapi.schema.OldPosition;
import com.google.code.linkedinapi.schema.Person;

public class CompanyPersonUpdateImpl
	extends BaseSchemaEntity
	implements CompanyPersonUpdate
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected PersonImpl person;
    protected ActionImpl action;
    protected OldPositionImpl oldPosition;
    protected NewPositionImpl newPosition;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = ((PersonImpl) value);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action value) {
        this.action = ((ActionImpl) value);
    }

    public OldPosition getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(OldPosition value) {
        this.oldPosition = ((OldPositionImpl) value);
    }

    public NewPosition getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(NewPosition value) {
        this.newPosition = ((NewPositionImpl) value);
    }

	@Override
	public void init(XmlPullParser parser) throws IOException,
			XmlPullParserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
