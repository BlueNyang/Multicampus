import type { JSX } from 'react';

export default function App(): JSX.Element {
  return (
    <div>
      <h4 className='text-xl text-blue-300'>&lt;s_cover&gt;</h4>
      <div className='relative mx-auto grid h-[400px] w-[700px] grid-cols-3 gap-4 rounded-2xl border border-blue-300 p-4'>
        <div className='rounded-2xl border border-red-300 text-red-300'>&lt;s_cover_item&gt;</div>
        <div className='rounded-2xl border border-green-300 text-green-300'>
          &lt;s_cover_item&gt;
        </div>
        <div className='rounded-2xl border border-yellow-300 text-yellow-300'>
          &lt;s_cover_item&gt;
        </div>
        <div className='rounded-2xl border border-purple-300 text-purple-300'>
          &lt;s_cover_item&gt;
        </div>
        <div className='rounded-2xl border border-pink-300 text-pink-300'>&lt;s_cover_item&gt;</div>
        <div className='rounded-2xl border border-gray-300 text-gray-300'>&lt;s_cover_item&gt;</div>
      </div>
    </div>
  );
}
