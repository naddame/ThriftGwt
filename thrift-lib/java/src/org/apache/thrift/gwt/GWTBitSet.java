  /*
   * Licensed to the Apache Software Foundation (ASF) under one
   * or more contributor license agreements. See the NOTICE file
   * distributed with this work for additional information
   * regarding copyright ownership. The ASF licenses this file
   * to you under the Apache License, Version 2.0 (the
   * "License"); you may not use this file except in compliance
   * with the License. You may obtain a copy of the License at
   *
   *   http://www.apache.org/licenses/LICENSE-2.0
   *
   * Unless required by applicable law or agreed to in writing,
   * software distributed under the License is distributed on an
   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
   * KIND, either express or implied. See the License for the
   * specific language governing permissions and limitations
   * under the License.
   */
  
  package org.apache.thrift.gwt;
  
  public class GWTBitSet implements java.io.Serializable {
    
    /**
     * Array of bytes to store the bit set.
     */
    private byte[] bits = null;
    
    /**
     * Index of the highest bit accessed in the set
     */
    private int highbit = -1;
    
    public GWTBitSet() {    
    }
    
    /**
     * Constructor that specifies the initial size of the bit set.
     * 
     * @param size
     */
    public GWTBitSet(int size) {
      this.highbit = size - 1;
    }
    
    public void set(int bitIndex) {
  
      //
      // Update highest bit accessed
      //
      if (bitIndex > highbit) {
        highbit = bitIndex;
      }
      
      int byteOffset = bitIndex >> 3;
      
      //
      // We need to allocate or grow the bit field
      //
      
      if (null == bits || byteOffset >= bits.length) {
        byte[] tmp = new byte[byteOffset + 1];
        
        if (null != bits) {
          System.arraycopy(bits, 0, tmp, 0, bits.length);
        }
        
        bits = tmp;
      }
      
      byte bitMask = (byte)(0x80 >> (bitIndex % 8));
      bits[byteOffset] = (byte) (bits[byteOffset] | (byte) bitMask);
    }
  
    public void set(int bitIndex, boolean value) {
      if (value) {
        set(bitIndex);
      } else {
        clear(bitIndex);
      }
    }
  
    /**
     * Get the value of the specified bit.
     * If the requested bit is outside the currently allocated set,
     * do not resize the set but simply return false.
     * 
     * @param bitIndex Index of the bit to retrieve.
     * @return
     */
    public boolean get(int bitIndex) {
  
      //
      // Update highest bit accessed
      //
      if (bitIndex > highbit) {
        highbit = bitIndex;
      }
      
      int byteOffset = bitIndex >> 3;
      
      if (null != bits && byteOffset < bits.length) {
        byte bitMask = (byte)(0x80 >> (bitIndex % 8));
        return 0 != (bits[byteOffset] & (byte) bitMask);
      }        
      
      return false;
    }
    
    /**
     * Clear a bit of the bit set.
     * If the cleared bit is outside the currently allocated set,
     * do not resize the set as we are clearing the bit.
     * 
     * @param bitIndex Index of the bit to clear.
     */
    public void clear(int bitIndex) {
  
      //
      // Update highest bit accessed
      //
      if (bitIndex > highbit) {
        highbit = bitIndex;
      }
      
      int byteOffset = bitIndex >> 3;
      
      if (null != bits && byteOffset < bits.length) {
        byte bitMask = (byte)(0x80 >> (bitIndex % 8));
        bits[byteOffset] = (byte) (bits[byteOffset] & (byte) ((byte) 0xff ^ (byte) bitMask));
      }    
    }
    
    public void clear() {
      this.bits = null;
    }
    
    /**
     * Performs a logical OR of this bit set with the bit set argument.
     * 
     * @param Bit set to OR this one with.
     */
    public void or(GWTBitSet other) {
      int count = other.size();
      
      for (int i = 0; i < count; i++) {
        if (other.get(i)) {
          set(i);
        }
      }
    }
    
    /**
     * Return the size in bits of the bit set.
     * 
     * @return
     */
    public int size() {
      return highbit + 1;
    }
    
    /**
     * Return a String representation of this bit set.
     */
    public String toString() {
      StringBuilder sb = new StringBuilder();
      
      int maxbit = highbit;
  
      for (int i = 0; i <= maxbit; i++) {
        if (this.get(i)) {
          sb.append("1");
        } else {
          sb.append("0");
        }
      }
  
      return sb.toString();      
    }
  }