/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.example;

import org.openjdk.jmh.annotations.Benchmark;

public class MyBenchmark {


    public static int find(int[] a, int id) {
        while(a[id]!=id) id=a[id];
        return id;
    }

    public static void union(int[] a, int p, int q) {

        a[find(a,q)]=find(a,p);
    }

    @Benchmark
    public void findTest() {
        // for (int i = 0; i < 1000; i++);
        int[] array;
        array = new int[9];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        array[4] = 4;
        array[5] = 5;
        array[6] = -1;
        array[7] = 7;
        array[8] = 8;
        int x = array[2];
        find(array, x);
    }

    @Benchmark
    public void unionTest() {
        //  int i = 0;
        //  while (i < 1000){
        //      i++;
        int[] array;
        array = new int[9];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        array[4] = 4;
        array[5] = 5;
        array[6] = -1;
        array[7] = 7;
        array[8] = 8;
        int x = array[2];
        int y = array[3];
        union(array, x, y);
    }


    @Benchmark
    public void unionTest2() {
        //  int i = 0;
        //  while (i < 1000){
        //      i++;
        int[] array2;
        array2 = new int[100];
        array2[0] = 0;
        array2[1] = 1;
        array2[2] = 2;
        array2[33] = 33;
        array2[4] = 4;
        array2[41] = 41;
        array2[6] = -1;
        array2[7] = 7;
        array2[77] = 77;
        int x = array2[2];
        int y = array2[77];
        union(array2, x, y);
    }
}

