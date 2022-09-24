package com.jiayu;

import com.easycode.CoverageSampleMethods;
import com.stream.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
@ComponentScan
@RunWith(SpringJUnit4ClassRunner.class)
class RabbitmqApplicationTests {
	AopTest aopTest = new AopTest();
	@Test
	void downLoad() {
		aopTest.downLoad();
	}

	@Test
	//通过stream方法，把list或数组转换为流
	public void stream() {
		Arrays.asList("a1", "a2", "a3").stream().forEach(System.out::println);
		Arrays.stream(new int[]{1,2,3}).forEach(System.out::println);
	}

	@Test
	public void of() {
		String[] arr = {"a", "b", "c"};
		Stream.of(arr).forEach(System.out::println);
		Stream.of("a", "b", "c").forEach(System.out::println);
		Stream.of(1, 2, "a").map(item -> ((Comparable) item).getClass()).forEach(System.out::println);

	}
 	@Test
	public void iterate() {
		Stream.iterate(1, item -> item * 2).limit(10).forEach(System.out::println);
		Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.TEN)).limit(10).forEach(System.out::println);
	}

	@Test
	public void generate() {
		Stream.generate(() -> "test").limit(3).forEach(System.out::println);
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
	}
	@Test
	public void primitive() {
//		IntStream.range(1, 3).forEach(System.out::println);
//		IntStream.range(0, 3).mapToObj(i -> "x").forEach(System.out::println);

//		IntStream.rangeClosed(1, 3).forEach(System.out::println);
//		DoubleStream.of(1.1, 2.2, 3.3).forEach(System.out::println);

//		System.out.println(IntStream.of(1, 2).toArray().getClass());
//		System.out.println(Stream.of(1, 2).mapToInt(Integer::intValue).toArray().getClass());
//		System.out.println(IntStream.of(1, 2).boxed().toArray().getClass());
//		System.out.println(IntStream.of(1,2).asDoubleStream().toArray().getClass());
		System.out.println(IntStream.of(1,2).asLongStream().toArray().getClass());
	}






	@Test
	void contextLoads() {
	}

	@org.junit.Test
	public void optional() {
//		assertThat(Optional.of(1).get(), is(1));
//		assertThat(Optional.ofNullable(null).orElse("A"), is("A"));
	}

	@Test
	public void fori() {
		System.out.println(IntStream.rangeClosed(1, 10)
				.mapToObj(i -> new Customer(1, "jiayu" + i))
				.collect(Collectors.toList()));

		new Thread(new Runnable() {
			@Override
			public void run() {

			}
		}).start();
	}

	private void increment(AtomicInteger atomicInteger) {
		atomicInteger.incrementAndGet();
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void countDownLunch() throws InterruptedException {
		int thread = thread(10000, 20);
		System.out.println(thread);
	}

	private int thread(int taskCount, int threadCount) throws InterruptedException {
		//总操作次数计数器
		AtomicInteger atomicInteger = new AtomicInteger();
		//使用countDownLunch来等待所有线程执行完成
		CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		//使用IntStream把数字直接转为Threadd
		IntStream.rangeClosed(1, threadCount).mapToObj(i -> new Thread(() -> {
			IntStream.rangeClosed(1, taskCount / threadCount).forEach(j -> increment(atomicInteger));
			countDownLatch.countDown();
		})).forEach(Thread ::start);
		countDownLatch.await();
		return atomicInteger.get();
	}



}
