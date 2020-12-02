s<-read.table("E:/proj/proj1/data.csv",sep=",",header=TRUE)
nrow(s)
pos<-s[s$Class=="positive",]
neg<-s[s$Class=="negative",]
nrow(pos)
nrow(neg)
train1<-sample(nrow(s),0.7*nrow(s))

traindata<-s[train1,]
testdata<-s[-train1,]

nrow(traindata)
nrow(testdata)

DecTree <- function(s)
{
  pos<-s[s$Class=="positive",]
  neg<-s[s$Class=="negative",]
  b<-nrow(pos)
  m<-nrow(neg)
  
  n<-nrow(s) 
  info<- -(b/n)*log(b/n) -(m/n)*log(m/n)
  info
  clist<-c()
  for(k in 2:30)
  {
    w<-table(s[,k],s$Class)
    w
    tsum<-0
    for(i in 1:nrow(w))
    {
      sum<-w[i,1]+w[i,2]
      a1<- w[i,1]/sum
      a2<- w[i,2]/sum
      if(a1>0 && a2>0)
        tsum<- tsum + sum/n * ((-a1*log(a1)) - (a2*log(a2)))
      if(a1==0)
        tsum<- tsum + sum/n *  (- (a2*log(a2)))
      if(a2==0)
        tsum<- tsum + sum/n * ((-a1*log(a1))) 
    }
    attinfo<- info - tsum
    clist<-c(clist,attinfo)
  }
  clist
  return (which.max(clist))
}
clist
i<-DecTree(s)
i<-i+1
i
w<-table(s[,25],s$Class)
w

n<-names(s)
n1<-n[i]
n1
s1<-s[s$Price==0,]
nrow(s1)
s2<-s[s$Price==1,]
nrow(s2)
i1<-DecTree(s1)
i1
name<-names(s)
name
news<-s[s[,index]==1,]
nrow(news)
