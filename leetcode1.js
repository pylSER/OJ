var findPeakElement = function(nums) {

    if(nums.length==1){
        return 0;
    }

    for (let index = 0; index < nums.length; index++) {
        const element = nums[index];
        if(index==0){
            if(element>nums[1]){
                return 0;
            }else{
                continue;
            }
        }

        if(index==nums.length-1){
            if(element>nums[index-1]){
                return index;
            }else{
                continue;
            }
        }


        if(element>nums[index-1]&&element>nums[index+1]){
            return index;
        }
    }
 };


 var maximumSwap = function(num) {
    let maxNum=0;

    let maxPos=0;

    let numStr=num+"";
    for (let index = 0; index < numStr.length; index++) {
        const num = numStr[index];
        if(num>maxNum){
            maxNum=num;
            maxPos=index;
        }
    }

    //swap
    let firstNum=numStr[0];
    
    let res=maxNum;

    for(let index = 0; index < numStr.length; index++){
        if(index==maxPos){
            res+=firstNum;
            continue;
        }

        res+=numStr[index];

    }
    

    return res;
};


var constructRectangle = function(area) {
    let isDivide=function(num,target){
        let mod=target%num;

        if(mod==0){
            return true;
        }else{
            return false;
        }
    }



    let sqrt=Math.sqrt(area);

    let length=Math.ceil(sqrt);

    while(!isDivide(length,area)){
        length+=1;
    }

    let res=[length,area/length];

    return res;
};


var isBalanced = function(root) {

    let result=true;
    
    let getDepth=function(node){
        if(result==false){
            return;
        }


        if(node.right==null&&node.left==null){ // this is a leaf
            node.height=0;
            return;
            
        }else if(node.right==null&&node.left!=null){
            getDepth(node.left);
            node.height=node.left.height+1;
            if(node.height>1){
                result=false;
            }


        }else if(node.right!=null&&node.left==null){
            getDepth(node.right);
            node.height=node.right.height+1;
            if(node.height>1){
                result=false;
            }
        }else if(node.right!=null&&node.left!=null){
            getDepth(node.left);
            getDepth(node.right);
            if(Math.abs(node.right.height-node.left.height)>1){
                result=false;
            }

            node.height=Math.max(node.right.height,node.left.height)+1;
        }
    }
    if(root==null){
        return true;
    }else{
        getDepth(root);
    }
    
    console.log(result);
    return result;
};


// let root={
//     val: 3,
//     right: 
//      {
//        val: 20,
//        right:{ val: 7, right: null, left: null },
//        left: { val: 15, right: null, left: null } },
//     left: { val: 9, right: null, left: null } }

let root={
    val: 1,
    right: {
       val: 2,
       right:null,
       left: null
     },
    left: { 
        val:2,
        left:{
            val:3,
            left:{
                val:4,
                left:null,
                right:null
            },
            right:{
                val:4,
                left:null,
                right:null
            }
        },
        right:{
            val:3,
            left:null,
            right:null
        }
    }
}



var mergeTwoLists = function(l1, l2) {
    if(l1==null||l1.length==0){
        return l2;
    }

    if(l2==null||l2.length==0){
        return l1;
    }


    let arr1=[];
    let node1=l1;

    let arr2=[];
    let node2=l2;

    while(node1.next!=null){
        arr1.push(node1.val);
        node1=node1.next;
    }
    arr1.push(node1.val);

    while(node2.next!=null){
        arr2.push(node2.val);
        node2=node2.next;
    }
    arr2.push(node2.val);


    let pointer1=0;
    let pointer2=0;

    let counter=0;


    let resArr=[];

    while(counter<(arr1.length+arr2.length)){
        //
        if(pointer1==arr1.length){
            resArr[counter]=arr2[pointer2];
            pointer2++;
            counter++;
            continue;
        }

        if(pointer2==arr2.length){
            resArr[counter]=arr1[pointer1];
            pointer1++;
            counter++;
            continue;
        }

        if(arr1[pointer1]<=arr2[pointer2]){
            resArr[counter]=arr1[pointer1];
            pointer1++;
        }else{
            resArr[counter]=arr2[pointer2];
            pointer2++;
        }

        counter++;
    }

    let arr2LinkedList=function(arr){
        let resLinkedList={
            val:arr[0],
            next:null
        };

        let other=resLinkedList;


        for(let i=1;i<arr.length;i++){
            let temp={
                val:arr[i],
                next:null
            }

            other.next=temp;
            other=temp;
        }

        return resLinkedList;
    }


    return arr2LinkedList(resArr);
};

let l1={
    val:1,
    next:{
        val:2,
        next:{
            val:4,
            next:null
        }
    }
};

let l2={
    val:1,
    next:{
        val:3,
        next:{
            val:4,
            next:null
        }
    }
};

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    let isArrEqual=(arr1,arr2)=>{
        for (let index = 0; index < arr1.length; index++) {
            const arr1Value = arr1[index];
            const arr2Value = arr2[index];

            if(arr2Value!=arr1Value){
                return false;
            }
        }
        return true;
    }

    let findNextBigNum=(arr)=>{
        let swapArr=(array,index1,index2)=>{
            let temp=array[index1];
            array[index1]=arr[index2];
            array[index2]=temp;
        }


        // choose one to swap
        let swapIndex=0;
        for(let i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                swapIndex=i;
            }
        }

        //find the bigger one
        let biggerIndex=swapIndex+1;
        let biggerValue=arr[swapIndex+1];
        for(let i=swapIndex;i<arr.length;i++){
            if(arr[swapIndex]<arr[i]){
                if(biggerValue>arr[i]){
                    biggerValue=arr[i];
                    biggerIndex=i;
                }
            }
        }

        //swap
        swapArr(arr,swapIndex,biggerIndex);

        //reverse
        let loopTime=Math.floor((arr.length-swapIndex)/2);
        let reverseIndex=arr.length-1;
        for(let i=swapIndex+1;i<swapIndex+1+loopTime;i++){
            swapArr(arr,i,reverseIndex);
            reverseIndex--;
        }


        return arr;
    }

    // dict 
    let resArr=[];

    let sortedNums=nums.sort();

    let currentNums=[];

    let ascArr=[];

    sortedNums.forEach(element => {
        ascArr.push(element);
    });

    sortedNums.forEach(element => {
        currentNums.push(element);
    });

    resArr.push(ascArr);

    let descNums=nums.sort((a,b)=>{
        return b-a;
    });
 

    while(!isArrEqual(currentNums,descNums)){
        
        currentNums=findNextBigNum(currentNums);
        let tempArr=[];
        currentNums.forEach(element => {
            tempArr.push(element);
        });
        resArr.push(tempArr);
    }

    return resArr;
};

console.log(permute([1,2,3]));


var isSymmetric = function(root) {
    
    let postOrder="";


    let getPostOrder=(root)=>{
        if(root==null){
            postOrder+="n";
            return;
        }
        
        if(root.left==null&&root.right==null){
            postOrder+=root.val;
            return;
        }else{
            getPostOrder(root.left);
            getPostOrder(root.right);
            postOrder+=root.val;
        }
        
    }

    getPostOrder(root);

    let before=postOrder;
    postOrder="";


    //do reverse
    let reverseTree=(root)=>{
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }

        let temp=root.left;
        root.left=root.right;
        root.right=temp;

        reverseTree(root.left);
        reverseTree(root.right)
    }

    reverseTree(root);

    getPostOrder(root);

    if(before==postOrder){
        return true;
    }else{
        return false;
    }
};


var findDuplicate = function(nums) {
    //Floyd cycle detection

    let slowPointer=0;
    let fastPointer=0;

    slowPointer=nums[0];
    fastPointer=nums[nums[0]];

    while(slowPointer!=fastPointer){
        slowPointer=nums[slowPointer];
        fastPointer=nums[nums[fastPointer]];
    }  


    let crossPointer=0;

    while(nums[crossPointer]!=nums[slowPointer]){
        slowPointer=nums[slowPointer];
        crossPointer=nums[crossPointer];
    }

    return nums[crossPointer];
};

var isHappy = function(n) {
    let strN=n+"";

    let ans=0;

    while(ans!=1){
       
        for (let index = 0; index < strN.length; index++) {
            const charc = strN.charAt(index);
            let numc=parseInt(charc);
            ans+=numc*numc;
        }
        strN=ans+"";
    }

    return true;
};


var sumOfLeftLeaves = function(root) {
    let sum=0;

    let travelRoot=(root,isLeft)=>{
        if(root==null){
            return;
        }


        if(root.left==null&&root.right==null){
            if(isLeft){
                sum+=root.val;
            }
            return;
        }


        travelRoot(root.left,true);

        travelRoot(root.right,false);
    }

    travelRoot(root,false);

    return sum;


};


var toHex = function(num) {
    if(num==0){
        return "0";
    }else if(num>0){
        return num.toString(16);
    }else{
        let reverseArr={
            "0":"f",
            "1":"e",
            "2":"d",
            "3":"c",
            "4":"b",
            "5":"a",
            "6":"9",
            "7":"8",
            "8":"7",
            "9":"6",
            "a":"5",
            "b":"4",
            "c":"3",
            "d":"2",
            "e":"1",
            "f":"0",
        };
        let posNum=-num;
        let posHex=posNum.toString(16);

        let posHexReverse="";

        for (let index = 0; index < posHex.length; index++) {
            const element = posHex.charAt(index);
            let reChar=reverseArr[element];
            posHexReverse+=reChar;
        }


        let prefix="";
        for (let index = 0; index < 8-posHexReverse.length; index++) {
            prefix+="f";
        }

        let posHexMinus=prefix+posHexReverse;

        //plus 1

        let plusOneArr={
            "0":"1",
            "1":"2",
            "2":"3",
            "3":"4",
            "4":"5",
            "5":"6",
            "6":"7",
            "7":"8",
            "8":"9",
            "9":"a",
            "a":"b",
            "b":"c",
            "c":"d",
            "d":"e",
            "e":"f",
            "f":"0",
        }

        let isNeedCarry=true;

        let addedStr="";

        for (let index = posHexMinus.length-1; index >=0; index--) {
            let orgChar=posHexMinus.charAt(index);

            let addedChar=plusOneArr[orgChar];

            if(isNeedCarry==true){
                addedStr+=addedChar;
                if(addedChar!="0"){
                    isNeedCarry=false;
                }
            }else{
                break;
            }
        }

        let res="";

        for (let index = 0; index < 8-addedStr.length; index++) {
            res+=posHexMinus.charAt(index);
        }

        for (let index = addedStr.length-1; index >=0; index--) {
            let addChar=addedStr.charAt(index);
            res+=addChar;
        }

        return res;
    }
};


var maxProfit = function(prices) {
    let max=0;


    for (let index = 0; index < array.length-1; index++) {
        const element = prices[index];
        
        if(element<prices[index+1]){
            max+=prices[index+1]-element;
        }
    }

    return max;
};

var maxProfit = function(prices,fee) {
    let getRangeArr=(prices)=>{
        let arr=[];

        let isBigger=false;

        if(prices[0]<prices[1]){
            isBigger=true;
        }else{
            isBigger=false;
        }

        let first=prices[0];

        let last=prices[1];

        for (let index = 0; index < prices.length-1; index++) {
            const element = prices[index];

            if(prices[index]<prices[index+1]){
                if(isBigger==true){
                    last=prices[index+1];
                }else{
                    arr.push(last-first);
                    first=prices[index];
                    last=prices[index+1];
                }
                isBigger=true;
            }else{
                if(isBigger==true){
                    arr.push(last-first);
                    first=prices[index];
                    last=prices[index+1];
                }else{
                    last=prices[index+1];
                }
                isBigger=false;
            }
        }

        arr.push(last-first);
        
        return arr;
    }

    let rangeArr=getRangeArr(prices);


    let feeTime=0;
    let max=0;

    let start=0;

    if(rangeArr[0]<0){
        start=1;
    }
    for (let index = start; index < rangeArr.length; index++) {
        if(index==(rangeArr.length-1)&&rangeArr[index]<0){
            continue;
        }
        const element = rangeArr[index];
        if(element>0){
            max+=element;
        }else{
            let k=0-element;
            if(k<fee){//hold
                max+=element;
            }else{//sell
                feeTime++;
            }
        }
    }

    let res= max-((feeTime+1)*fee);
    if(res<0){
        return 0;
    }else{
        return res;
    }
};


var mirrorReflection = function(p, q) {

    let isPTimes=(num,p)=>{
        if(num%p==0){
            return true;
        }else{
            return false;
        }
    }

    let qNum=q;

    let count=2;

    while(!isPTimes(qNum,p)){
        qNum=count*q;
        count++;
    }

    let heightNum=qNum/p;

    let lengthNum=count-1;

    let isOnRigthSide=false;

    if(lengthNum%2==0){
        isOnRigthSide=false;
    }else{
        isOnRigthSide=true;
    }

    if(isOnRigthSide==true){
        if(heightNum%2==0){
            return 0;
        }else{
            return 1;
        }
    }else{
        return 2;
    }
}

var new21Game = function(N, K, W) {
    let cardArr=[];

    let total=10;

    let ok=0;

    for (let index = 1; index <=W; index++) {
        if(index>=K){
            if(index<=N){
                ok++;
            }
            continue;
        }
        cardArr.push(index);
    }
};

var buddyStrings = function(A, B) {
    if(A.length!=B.length){
        return false;
    }

    let diffArrA=[];

    let diffArrB=[];

    for (let index = 0; index < A.length; index++) {
        const charA = A.charAt(index);
        const charB = B.charAt(index);

        if(charA!=charB){
            diffArrA.push(charA);
            diffArrB.push(charB);
        }
    }

    if(diffArrA.length>2){
        return false; 
    }

    if(diffArrA.length==2){
        if(diffArrA[0]==diffArrB[1]&&diffArrA[1]==diffArrB[0]){
            return true;
        }else{
            return false;
        }
    }

    if(diffArrA.length==0){
        // same string
        let dict={};
        for (let index = 0; index < A.length; index++) {
            const element = A.charAt(index);
           
            if(dict[element]==true){
                return true;
            }
           
            dict[element]=true;
        }

        return false;
    }

};

var checkPossibility = function(nums) {
   for (let index = 0; index < nums.length-1; index++) {
       const element = nums[index];

       let lessNum=0;

       for (let j = index+1; j < nums.length; j++) {
           const element2 = nums[j];

           if(element>element2){
                lessNum++;
           }
       }

       if(lessNum>=2){
            return false;
       }
       
   }

   return true;
};

var findSecondMinimumValue = function(root) {
    let secondValue=-1;

    let maxValue=-1;

    let getMaxValue=(root)=>{
        if(root==null){
            return;
        }

        if(root.val>maxValue){
            secondValue=maxValue;
            maxValue=root.val;
        }

        getMaxValue(root.left);
        getMaxValue(root.right);
    }

    getMaxValue(root);

    return secondValue;
};

var reachNumber = function(target) {
    


    let isPossible=(target,stepUsed)=>{
        //TODO
        if(stepUsed==0){
            if(target==0){
                return true;
            }else{
                return false;
            }  
        }

        if(stepUsed==1){
            if(target==-1||target==1){
                return true;
            }else{
                return false;
            }
        }
        return (isPossible(target+stepUsed,stepUsed-1)||isPossible(target-stepUsed,stepUsed-1));
    }

    let stepTry=0;


    while(!isPossible(target,stepTry)){
        stepTry++;
    }

    return stepTry;
};

var leastInterval = function(tasks, n) {
    let table={
        A:{
            nums:0,
            cd:0
        },
        B:{
            nums:0,
            cd:0
        },
        C:{
            nums:0,
            cd:0
        },
        D:{
            nums:0,
            cd:0
        },
        E:{
            nums:0,
            cd:0
        },
        F:{
            nums:0,
            cd:0
        },
        G:{
            nums:0,
            cd:0
        },
        H:{
            nums:0,
            cd:0
        },
        I:{
            nums:0,
            cd:0
        },
        J:{
            nums:0,
            cd:0
        },
        K:{
            nums:0,
            cd:0
        },
        L:{
            nums:0,
            cd:0
        },
        M:{
            nums:0,
            cd:0
        },
        N:{
            nums:0,
            cd:0
        },
        O:{
            nums:0,
            cd:0
        },
        A:{
            nums:0,
            cd:0
        },
        P:{
            nums:0,
            cd:0
        },
        Q:{
            nums:0,
            cd:0
        },
        R:{
            nums:0,
            cd:0
        },
        S:{
            nums:0,
            cd:0
        },
        T:{
            nums:0,
            cd:0
        },
        U:{
            nums:0,
            cd:0
        },
        V:{
            nums:0,
            cd:0
        },
        W:{
            nums:0,
            cd:0
        },
        X:{
            nums:0,
            cd:0
        },
        Q:{
            nums:0,
            cd:0
        },
        Y:{
            nums:0,
            cd:0
        },
        Z:{
            nums:0,
            cd:0
        }
    };


    let pickATaskAndRun=(totalTaskNum)=>{
        //TODO
        //1. pick a task (has num no cd)
        //2. add cd for this task
        //3. minus cd for other task

        let pickedKey="";

        //choose max num

        let maxNums=0;
        let maxNumKey="";

        for (const key in table) {
            if(table[key].nums>0&&table[key].cd==0){
                if(table[key].nums>maxNums){
                    maxNums=table[key].nums;
                    maxNumKey=key;
                }
            }
        }

        if(maxNumKey!=""){
            table[maxNumKey].nums--;
            table[maxNumKey].cd=n;
            pickedKey=maxNumKey;
        }
        

        // minus cd
        for (const key in table) {
            if(key!=pickedKey){
                if(table[key].cd>0){
                    table[key].cd--;
                }
            }
        }



        if(pickedKey!=""){// now we picked one
            return totalTaskNum-1;
        }else{ // all in cd 
            return totalTaskNum;
        }
    }



    for (let index = 0; index < tasks.length; index++) {
        const element = tasks[index];
        table[element].nums++;
    }

    // start running
    let totalTaskNum=tasks.length;
    let step=0;

    while(totalTaskNum!=0){
        totalTaskNum=pickATaskAndRun(totalTaskNum);
        step++;
    }

    return step;  ///["A","B","C","D","B","B"] 2
};


var flipAndInvertImage = function(A) {
    let B=A.map(((x)=>{
        let y=x.reverse();
        return y.map((pixel)=>{
            if(pixel==1){
                return 0;
            }else{
                return 1;
            }
        });
    }));
    
    console.log(B);
};
var moveZeroes = function(nums){
    let swap=(i,j)=>{
        let temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }



    let memoArr=[];
    for (let index = 0; index < nums.length; index++) {
        const element = nums[index];
        if(element!=0){
            memoArr.push(index);
        }
    }

    for (let index = 0; index < nums.length; index++) {
        const element = nums[index];
        let currZeroInex=index;
        if(element==0){
            for (let j = 0; j < memoArr.length; j++) {
                const memoElement = memoArr[j];
                swap(currZeroInex,memoArr[j]);
                let temp=currZeroInex;
                currZeroInex=memoArr[j];
                memoArr[j]=temp;
            }
        }
    }


    console.log(nums);
};

/**
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms = function(rooms) {
    let memoArr=new Array(rooms.length);

    for (let index = 0; index < rooms.length; index++) {
        if(index==0){
            memoArr[0]=1;
        }else{
            memoArr[index]=0;   
        }
    }

    let goToTheRoom=(roomNum)=>{
        if(memoArr[roomNum]==1){
            return;
        }else{
            memoArr[roomNum]=1;
            //goToNext
            let roomKeys=rooms[roomNum];
            for (let index = 0; index < roomKeys.length; index++) {
                const element = roomKeys[index];
                goToTheRoom(element);
            }
        }
    }

    let room0Keys=rooms[0];
    for (let index = 0; index < room0Keys.length; index++) {
        const element = room0Keys[index];
        goToTheRoom(element);
    }

    for (let index = 0; index < memoArr.length; index++) {
        const element = memoArr[index];
        if(element==0){
            return false;
        }
    }

    return true;
};


var generate = function(numRows) {
    if(numRows==0){
        return [];
    }



    let res=[[1]];
    


    for (let index = 2; index <= numRows; index++) {
        let temp=[];

        for (let J = 0; J < index; J++) {
            let leftNum=0;
            if(J!=0){
                leftNum=res[index-2][J-1];
            }
            let rightNum=0;
            if(J!=index-1){
                rightNum=res[index-2][J];
            }
            temp.push((leftNum+rightNum));
        }

        res.push(temp);
    }

    return res;
};

var countSmaller = function(nums) {
    let res=[];
    for (let i = 0; i < nums.length; i++) {
        const element = nums[i];
        let number=0;
        for (let j = i+1; j < nums.length; j++) {
            const ele1 = nums[j];
            if(element>ele1){
                number++;
            }
        }
        res.push(number);
    }
    return res;
};

var minEatingSpeed = function(piles, H) {
    piles.sort(((a,b)=>{
        return a-b;
    }));
    
    console.log(piles);

    let getSum=(total,num)=>{
        return total+num;
    }
    
    let eatHour=(piles,rate)=>{
        let arr=piles.map((x)=>{
            return Math.ceil(x/rate);
        });
        
        let res= arr.reduce(getSum);
        console.log("need "+res+" hour at rate"+rate);
        return res;
    }

    if(H<=piles[piles.length-1]){
        return piles[piles.length-1];
    }else {
        //eat less than max
        let lowerIndex=0;

        for (let i =0 ; i <=piles.length-2; i++) {
            if(eatHour(piles,piles[i])<=H){
                lowerIndex=i;
                break;
            }
        }
        
        console.log(lowerIndex);


        let lowerRate=piles[lowerIndex-1];
        let higherRate=piles[lowerIndex];


        let res=0;

        // get min rate  // er fen ?
        for (let index = lowerRate; index <=higherRate; index++) {
            if(eatHour(piles,index)==H){
                res=index;
                break;
            }
        }

        return res;
    }
};

var isPalindrome = function(head) {
    if(head==null){
        return true;
    }

    let currNode=head.next;
    let preNode=head;

    if(currNode==null){
        return true;
    }
    
    let nodeNum=2;

    while(currNode.next!=null){
        currNode.pre=preNode;
        preNode=currNode;
        currNode=currNode.next;
        nodeNum++;
    }

    //now currentNode is the last

    let startNode=head;

    let step=0;

    while(step!=nodeNum/2){
        if(currNode.val!=startNode.val){
            return false;
        }else{
            currNode=currNode.next;
            startNode=startNode.pre;
            step++;
        }
    }

    return true;
};

var isRectangleOverlap = function(rec1, rec2) {
    let range1X=[rec1[0],rec1[2]];
    let range1Y=[rec1[1],rec1[3]];

    let range2X=[rec2[0],rec2[2]];
    let range2Y=[rec2[1],rec2[3]];

    let isRangeCover=(rangeA,rangeB)=>{
        let leftOne=rangeA;
        let rightOne=rangeB;
        if(rangeA[0]>rangeB[0]){
            leftOne=rangeB;
            rightOne=rangeA;
        }

        if(rightOne[0]<=leftOne[1]){
            return true;
        }else{
            return false;
        }

    }

    let isXCovered=isRangeCover(range1X,range2X);
    let isYCovered=isRangeCover(range1Y,range2Y);

    if(isXCovered==true&&isYCovered==true){
        return true;
    }else{
        return false;
    }
};

var lemonadeChange = function(bills) {
    if(bills[0]!=5){
        return false;
    }

    let countArr=[1,0,0];//5,10,20

    for (let index = 1; index < bills.length; index++) {
        const element = bills[index];
        if(element==5){
            countArr[0]++;
            continue;
        }else if(element==10){
            if(countArr[0]>0){
                countArr[0]--;
                countArr[1]++;
            }else{
                return false;
            }
        }else{//20
            // 10 5 first
            if(countArr[0]>0&&countArr[1]>0){
                countArr[0]--;
                countArr[1]--;
                countArr[2]++;
            }else if(countArr[0]>=3){// 5 5 5 then
                countArr[0]-=3;
                countArr[2]++;
            }else{
                return false;
            } 
        }  
    }

    return true;
};

var dailyTemperatures = function(temperatures) {  //bad algo
    let res=[];
    let arr=[];
    for (let index = 0; index < temperatures.length; index++) {
        const element = temperatures[index];

        arr.push({
            val:element,
            index:index
        });
    }

    arr.sort((a,b)=>{
        return a.val-b.val;
    });

    let isStarted=false;

    for (let index = 0; index < arr.length; index++) {
        let realIndex=arr[index].index;
        let min=9999;

        let isFound=false;

        for (let j = index+1; j < arr.length; j++) {
            const nextIndex=arr[j].index;
            if(nextIndex>realIndex){
                if(nextIndex<min){
                    min=nextIndex;
                    isFound=true;
                }
            }
        }

        if(isFound==true){
            res[index]=min;
        }else{
            res[index]=0;
        }
        
    }

    return res;

};

var addTwoNumbers = function(l1, l2) {
    let parseLL=(head)=>{
        let str="";

        let currNode=head;

        while(currNode.next!=null){
            str+=currNode.val;
            currNode=currNode.next;
        }

        str+=currNode.val;

        return str;
    }

    let generateLL=(num)=>{
        let str=num+"";

        let headNode={
            val:0,
            next:null
        }

        let preNode;

        for (let index = 0; index < str.length; index++) {
            const c = str.charAt(index);
            if(index==0){
                headNode.val=parseInt(c);
                preNode=headNode;
            }else{
                let node={
                    val:parseInt(c),
                    next:null
                }

                preNode.next=node;
                preNode=node;
            }
            
        }

        return headNode;
    }

    let num2Arr=(num)=>{
        let str=num+"";
        let arr=[];
        for (let index = 0; index < str.length; index++) {
            const c = str.charAt(index);
            arr.push(parseInt(c));
        }
        return arr;
    }

    let str1=parseLL(l1);
    let str2=parseLL(l2);

    let num1=parseInt(str1);
    let num2=parseInt(str2);

    let res= num1+num2;

    return num2Arr(res);

};

var isSameTree = function(p, q) {
    let strP="";
    let strQ="";


    let goDFS=(node,str)=>{
        if(node==null){
            str+="n";
        }else{
            str+=node.val;
            goDFS(node.left,str);
            goDFS(node.right,str);
        }
    }

    goDFS(p,strP);

    goDFS(q,strQ);

    if(strP==strQ){
        return true;
    }else{
        return false;
    }
};


var solution = function(isBadVersion) {
    /**
     * @param {integer} n Total versions
     * @return {integer} The first bad version
     */
    return function(n) {
        //always left false right true

        let dp=(left,right)=>{
            if(left==right){
                return left;
            }

            if(right-left==1){
                if(isBadVersion(left)==true){
                    return left;
                }else{
                    return right;
                }
            }else{
                let middle=Math.floor((left+right)/2);
                if(isBadVersion(middle)==true){
                    return dp(left,middle);
                }else{
                    return dp(middle,right);
                }
            }
        }

        return dp(1,n);
        
    };
};







